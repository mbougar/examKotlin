package org.pebiblioteca
import java.util.*


/**
 * Clase que representa un catálogo de elementos de biblioteca.
 * @param T El tipo de elementos que contiene el catálogo, debe ser una subclase de [ElementoBiblioteca].
 * @property gestorElementos El gestor de elementos asociado al catálogo.
 */
class Catalogo<T: ElementoBiblioteca>(private val gestorElementos: GestorElementos<T>): ICatalogo<T>{

    /**
     * Agrega un elemento al catálogo.
     * @param elemento El elemento que se va a agregar.
     */
    override fun agregar(elemento: T) {
        gestorElementos.agregar(elemento)
    }

    /**
     * Elimina un elemento del catálogo dado su ID.
     * @param id El ID del elemento que se va a eliminar.
     */
    override fun eliminar(id: UUID) {
        gestorElementos.eliminarPorId(id)
    }

    /**
     * Busca un elemento en el catálogo dado su ID.
     * @param id El ID del elemento que se va a buscar.
     * @return El elemento encontrado, o null si no se encuentra.
     */
    override fun buscarPorId(id: UUID): T? {
        return gestorElementos.buscarPorId(id)
    }

    /**
     * Lista todos los elementos disponibles en el catálogo.
     * @return Una lista de elementos disponibles.
     */
    override fun listarDisponibles(): List<T> {
        return gestorElementos.filtrarPorCriterio(gestorElementos.devolverTodos()) { it.estado == EstadoElemento.DISPONIBLE }
    }

    /**
     * Devuelve el catálogo completo.
     * @return Una lista de todos los elementos en el catálogo.
     */
    override fun devolverCatalogo(): List<T> {
        return gestorElementos.devolverTodos()
    }
}