package org.pebiblioteca
import java.util.*


/**
 * Interfaz que define las operaciones básicas que debe proporcionar un catálogo de elementos de biblioteca.
 * @param T El tipo de elementos que se gestionarán, debe ser una subclase de [ElementoBiblioteca].
 */
interface ICatalogo<T : ElementoBiblioteca> {

    /**
     * Agrega un elemento al catálogo.
     * @param elemento El elemento que se va a agregar.
     */
    fun agregar(elemento: T)

    /**
     * Elimina un elemento del catálogo dado su ID.
     * @param id El ID del elemento que se va a eliminar.
     */
    fun eliminar(id: UUID)

    /**
     * Busca un elemento en el catálogo dado su ID.
     * @param id El ID del elemento que se va a buscar.
     * @return El elemento encontrado, o null si no se encuentra.
     */
    fun buscarPorId(id: UUID): T?

    /**
     * Lista todos los elementos disponibles en el catálogo.
     * @return Una lista de elementos disponibles.
     */
    fun listarDisponibles(): List<T>

    /**
     * Devuelve el catálogo completo.
     * @return Una lista de todos los elementos en el catálogo.
     */
    fun devolverCatalogo(): List<T>
}