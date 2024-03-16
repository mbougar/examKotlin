package org.pebiblioteca

/**
 * Clase que gestiona la interacción con la consola.
 */
class GestorConsola() {

    /**
     * Muestra un mensaje en la consola.
     * @param mensaje El mensaje que se mostrará en la consola.
     */
    fun mostrarMensaje(mensaje: String) {
        println(mensaje)
    }

    /**
     * Muestra el menú en la consola y solicita al usuario que seleccione una opción.
     * @return La opción seleccionada por el usuario.
     */
    fun mostrarMenu(): Int {
        println("\nMenú:")
        println("1. Agregar libro")
        println("2. Prestar libro")
        println("3. Devolver libro")
        println("4. Listar libros disponibles")
        println("5. Consultar historial de préstamos de un libro")
        println("6. Consultar historial de préstamos de un usuario")
        println("7. Salir")
        print("Seleccione una opción: ")

        return pedirOpcionNumerica()
    }

    /**
     * Solicita al usuario que ingrese una opción numérica desde la consola y la devuelve.
     * Si ocurre un error al convertir la entrada a un entero, se devuelve 0.
     * @return La opción numérica ingresada por el usuario o 0 si ocurrió un error.
     */
    private fun pedirOpcionNumerica(): Int {
        try {
            val opcion = readln().toInt()
            return opcion
        } catch (e: NumberFormatException) {
            return 0
        }
    }
}