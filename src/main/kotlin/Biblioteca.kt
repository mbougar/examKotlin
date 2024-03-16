package org.pebiblioteca


/**
 * Clase que representa una biblioteca.
 * @param T El tipo de elementos que contiene la biblioteca, debe ser una subclase de [ElementoBiblioteca].
 * @property gestorConsola El gestor de consola utilizado para mostrar mensajes y el menú.
 * @property gestorBiblioteca El gestor de la biblioteca que realiza operaciones relacionadas con la gestión de elementos.
 * @property listaLibros Lista temporal de libros para mostrar la funcionalidad.
 * @property usuarios Lista de usuarios de la biblioteca.
 */
class Biblioteca<T:ElementoBiblioteca>(
    private val gestorConsola: GestorConsola,
    private val gestorBiblioteca: GestorBiblioteca<T>,
    private val listaLibros: List<T>, //listas temporales para enseñar la funcionalidad
    private val usuarios: List<Usuario>
) {

    /**
     * Inicia la biblioteca y muestra el menú principal.
     */
    fun iniciar() {
        gestorConsola.mostrarMensaje("Se ha generado la Biblioteca.")
        mostrarMenu()
    }

    /**
     * Muestra el menú principal de la biblioteca y procesa las opciones seleccionadas por el usuario.
     */
    private fun mostrarMenu() {
        var opcion: Int
        do {
            opcion = gestorConsola.mostrarMenu()

            when (opcion) {
                1 -> agregarElemento()
                2 -> prestarElemento()
                3 -> devolverElemento()
                4 -> listarElementosDisponibles()
                5 -> consultarHistorialPrestamoElemento()
                6 -> consultarHistorialPrestamoUsuario()
                7 -> gestorConsola.mostrarMensaje("Cerrando la Biblioteca...\nAdiós.")
                else -> gestorConsola.mostrarMensaje("**Error** La opción introducida no es válida, por favor intentelo otra vez.")
            }
        } while (opcion != 7)
    }

    /**
     * Agrega un elemento aleatorio a la biblioteca y muestra un mensaje.
     */
    private fun agregarElemento() {
        gestorConsola.mostrarMensaje(gestorBiblioteca.agregar(listaLibros.random()))
    }

    /**
     * Presta un elemento aleatorio a un usuario aleatorio y muestra un mensaje.
     */
    private fun prestarElemento() {
        gestorConsola.mostrarMensaje(gestorBiblioteca.prestar(listaLibros.random().obtnerId(), usuarios.random()))
    }

    /**
     * Devuelve un elemento aleatorio prestado por un usuario aleatorio y muestra un mensaje.
     */
    private fun devolverElemento() {
        gestorConsola.mostrarMensaje(gestorBiblioteca.devolver(listaLibros.random().obtnerId(), usuarios.random()))
    }

    /**
     * Lista todos los elementos disponibles en la biblioteca y muestra un mensaje.
     */
    private fun listarElementosDisponibles() {
        gestorConsola.mostrarMensaje(gestorBiblioteca.listarElementosDisponibles().toString())
    }

    /**
     * Consulta el historial de préstamos de un libro aleatorio y muestra un mensaje.
     */
    private fun consultarHistorialPrestamoElemento() {
        gestorConsola.mostrarMensaje(gestorBiblioteca.consultarHistorialPrestamoElemento(listaLibros.random().obtnerId()).toString())
    }

    /**
     * Consulta el historial de préstamos de un usuario aleatorio y muestra un mensaje.
     */
    private fun consultarHistorialPrestamoUsuario() {
        gestorConsola.mostrarMensaje(gestorBiblioteca.consultarHistorialPrestamoUsuario(usuarios.random()).toString())
    }
}