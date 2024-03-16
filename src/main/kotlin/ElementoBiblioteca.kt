package org.pebiblioteca

import java.util.*


/**
 * Clase abstracta que representa un elemento de la biblioteca.
 * @property id El ID del elemento.
 * @property titulo El título del elemento.
 * @property estado El estado del elemento.
 */
abstract class ElementoBiblioteca(
    val id: UUID,
    val titulo: String,
    var estado: EstadoElemento
) {

    /**
     * Obtiene el ID del elemento.
     * @return El ID del elemento.
     */
    fun obtnerId() = id

    /**
     * Obtiene el título del elemento.
     * @return El título del elemento.
     */
    fun obtenerTitulo() = titulo

    /**
     * Obtiene el estado del elemento.
     * @return El estado del elemento.
     */
    fun obtenerEstado() = estado

    /**
     * Cambia el estado del elemento de disponible a prestado y viceversa.
     */
    fun cambiarEstado() {
        estado = if (estado == EstadoElemento.DISPONIBLE) EstadoElemento.PRESTADO else EstadoElemento.DISPONIBLE
    }
}