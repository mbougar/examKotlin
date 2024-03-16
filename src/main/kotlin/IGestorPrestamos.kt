package org.pebiblioteca
import java.util.*


/**
 * Interfaz para la gestion de préstamos de elementos.
 */
interface IGestorPrestamos {

    /**
     * Registra un préstamo de un elemento a un usuario.
     * @param elementoId El ID del elemento que se está prestando.
     * @param usuario El usuario al que se le está prestando el elemento.
     */
    fun registrarPrestamo(elementoId: UUID, usuario: Usuario)

    /**
     * Registra la devolución de un elemento por parte de un usuario.
     * @param elementoId El ID del elemento que se está devolviendo.
     * @param usuario El usuario que está devolviendo el elemento.
     */
    fun registrarDevolucion(elementoId: UUID, usuario: Usuario)

    /**
     * Consulta el historial de préstamos de un elemento dado su ID.
     * @param elementoId El ID del elemento del cual se quiere consultar el historial.
     * @return Una lista mutable de objetos [Prestamo] que representa el historial de préstamos del elemento.
     */
    fun consultarHistorialElemento(elementoId: UUID): MutableList<Prestamo>

    /**
     * Consulta el historial de préstamos de un usuario.
     * @param usuario El usuario del cual se quiere consultar el historial de préstamos.
     * @return Una lista mutable de objetos [Prestamo] que representa el historial de préstamos del usuario.
     */
    fun consultarHistorialUsuario(usuario: Usuario): MutableList<Prestamo>
}