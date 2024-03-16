package org.pebiblioteca
import java.util.*


/**
 * Class que representa un libro de la biblioteca.
 * @property id El identificador único del libro. Por defecto se genera utilizando la utilidad [UtilidadesBiblioteca.generarIdentificadorUnico].
 * @property titulo El título del libro.
 * @property autor El autor del libro.
 * @property anioDePublicacion El año de publicación del libro.
 * @property tematica La temática del libro.
 * @property estado El estado actual del libro. Por defecto es DISPONIBLE. Utiliza la descripción del estado
 *                      desde el enum [EstadoLibro].
 */
class Libro(
    id: UUID = UtilidadesBiblioteca.generarIdentificadorUnico(),
    titulo: String,
    private val autor: String,
    private val anioDePublicacion: Int,
    private val tematica: String,
    estado: EstadoElemento = EstadoElemento.DISPONIBLE): ElementoBiblioteca(id, titulo, estado), Prestable {

    /**
     * Obtiene el autor del libro.
     * @return El autor del libro.
     */
    fun obtenerAutor() = autor

    /**
     * Obtiene el año de publicación del libro.
     * @return El año de publicación del libro.
     */
    fun obtenerAnioPublicacion() = anioDePublicacion

    /**
     * Obtiene la temática del libro.
     * @return La temática del libro.
     */
    fun obtenerTematica() = tematica

    /**
     * Método que marca el libro como prestado.
     * Se implementa de la interfaz [Prestable].
     */
    override fun prestar() {
        if (estado == EstadoElemento.DISPONIBLE) {
            this.cambiarEstado()
        }
    }

    /**
     * Método que marca el libro como devuelto.
     * Se implementa de la interfaz [Prestable].
     */
    override fun devolver() {
        if (estado == EstadoElemento.PRESTADO) {
            this.cambiarEstado()
        }
    }
}