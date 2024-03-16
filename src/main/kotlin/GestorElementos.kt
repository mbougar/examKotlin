package org.pebiblioteca
import java.util.*


/**
 * Clase genérica que gestiona elementos de biblioteca.
 * @param T El tipo de elementos que se gestionarán, debe ser una subclase de [ElementoBiblioteca].
 */
class GestorElementos<T : ElementoBiblioteca> {

    private val elementos: MutableMap<UUID, T> = mutableMapOf() //Implementamos un map para facilitar la busqueda por id

    /**
     * Agrega un elemento al gestor de elementos.
     * @param elemento El elemento que se va a agregar.
     */
    fun agregar(elemento: T) {
        elementos[elemento.id] = elemento
    }

    /**
     * Elimina un elemento del gestor de elementos dado su ID.
     * @param id El ID del elemento que se va a eliminar.
     */
    fun eliminarPorId(id: UUID) {
        elementos.remove(id)
    }

    /**
     * Retorna todos los elementos gestionados.
     * @return Una lista de todos los elementos gestionados.
     */
    fun devolverTodos(): List<T> {
        return elementos.values.toList()
    }

    /**
     * Busca un elemento en el gestor de elementos dado su ID.
     * @param id El ID del elemento que se va a buscar.
     * @return El elemento encontrado, o null si no se encuentra.
     */
    fun buscarPorId(id: UUID): T? {
        return elementos[id]
    }

    /**
     * Filtra una lista de elementos basado en un criterio dado.
     * @param elementos La lista de elementos que se va a filtrar.
     * @param criterio El criterio de filtrado que se aplicará.
     * @return Una lista de elementos que cumplen con el criterio de filtrado.
     */
    fun <T> filtrarPorCriterio(elementos: List<T>, criterio: (T) -> Boolean): List<T> {
        return elementos.filter(criterio)
    }
}

