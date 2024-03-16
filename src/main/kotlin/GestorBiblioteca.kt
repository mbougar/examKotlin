package org.pebiblioteca
import java.util.*


/**
 * Clase que gestiona las operaciones relacionadas con la biblioteca.
 * @property catalogoElementos El catálogo de elementos de la biblioteca.
 * @property gestorPrestamos El registro de préstamos de elementos.
 */
class GestorBiblioteca<T:ElementoBiblioteca>(private val gestorPrestamos: IGestorPrestamos, private val catalogoElementos: ICatalogo<T>) {

    /**
     * Agrega un elemento al catálogo de la biblioteca.
     * @param elemento El elemento que se va a agregar.
     * @return Un mensaje indicando que el elemento se ha agregado correctamente.
     */
    fun agregar(elemento: T): String {
        catalogoElementos.agregar(elemento)
        return "Se ha agregado el elemento ${elemento.obtenerTitulo()}."
    }

    /**
     * Presta un elemento a un usuario.
     * @param elementoId El ID del elemento que se va a prestar.
     * @param usuario El usuario que toma prestado el elemento.
     * @return Un mensaje indicando si el préstamo se ha realizado correctamente o no.
     */
    fun prestar(elementoId: UUID, usuario: Usuario): String {
        val elemento = obtenerElemento(elementoId)
        if (elemento != null && elemento.obtenerEstado() == EstadoElemento.DISPONIBLE && elemento is Prestable) {
            elemento.prestar()
            usuario.agregarElemento(elemento)
            registrarPrestamo(elementoId, usuario)
            return "${usuario.obtenerNombre()} ha tomado prestado el elemento ${elemento.obtenerTitulo()}."
        } else {
            return "${usuario.obtenerNombre()} no ha tomado prestado el elemento ${elemento?.obtenerTitulo()}."
        }
    }

    private fun obtenerElemento(elementoId: UUID): T? {
        return catalogoElementos.buscarPorId(elementoId)
    }

    private fun registrarPrestamo(elementoId: UUID, usuario: Usuario) {
        gestorPrestamos.registrarPrestamo(elementoId, usuario)
    }

    /**
     * Devuelve un elemento prestado por un usuario.
     * @param elementoId El ID del elemento que se va a devolver.
     * @param usuario El usuario que devuelve el elemento.
     * @return Un mensaje indicando si la devolución se ha realizado correctamente o no.
     */
    fun devolver(elementoId: UUID, usuario: Usuario): String {
        val elemento = obtenerElemento(elementoId)
        if (elemento != null && elemento.obtenerEstado() == EstadoElemento.PRESTADO && elemento is Prestable) {
            elemento.devolver()
            usuario.eliminarElemento(elemento)
            registrarDevolucion(elementoId, usuario)
            return("${usuario.obtenerNombre()} ha devuelto el elemento ${catalogoElementos.buscarPorId(elementoId)!!.obtenerTitulo()}.")
        } else {
            return("${usuario.obtenerNombre()} no tenía ese elemento prestado.")
        }
    }

    private fun registrarDevolucion(elementoId: UUID, usuario: Usuario) {
        gestorPrestamos.registrarDevolucion(elementoId, usuario)
    }

    /**
     * Lista todos los elementos disponibles en la biblioteca.
     * @return Una lista de elementos disponibles.
     */
    fun listarElementosDisponibles(): List<T> {

        return catalogoElementos.listarDisponibles()
    }

    /**
     * Lista todos prestamos realizados para un elementos dada su Id.
     * @return Una lista de prestamos.
     */
    fun consultarHistorialPrestamoElemento(elementoId: UUID): MutableList<Prestamo> {
        val historialPrestamosElemento = gestorPrestamos.consultarHistorialElemento(elementoId)

        return historialPrestamosElemento
    }

    /**
     * Lista todos prestamos realizados para un [Usuario].
     * @return Una lista de prestamos.
     */
    fun consultarHistorialPrestamoUsuario(usuario: Usuario): MutableList<Prestamo> {
        val historialPrestamosUsuario = gestorPrestamos.consultarHistorialUsuario(usuario)

        return historialPrestamosUsuario
    }
}