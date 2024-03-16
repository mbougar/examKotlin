package org.pebiblioteca

/**
 * Interfaz que define el comportamiento de los elementos que pueden ser prestados y devueltos.
 */
interface Prestable {

    /**
     * Método que marca el elemento como prestado.
     */
    fun prestar()

    /**
     * Método que marca el elemento como devuelto.
     */
    fun devolver()
}