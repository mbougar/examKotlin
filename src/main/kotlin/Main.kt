package org.pebiblioteca

fun main() {
    val listaLibros = listOf(
    Libro(titulo = "Kotlin 1", autor = "Diego Cano", anioDePublicacion = 2023, tematica = "Fantasía"),
    Libro(titulo = "Kotlin 2", autor = "Diego Cano", anioDePublicacion = 2023, tematica = "Realismo mágico"),
        Libro(titulo = "Kotlin 3", autor = "Diego Cano", anioDePublicacion = 2023, tematica = "Drama"),
        Libro(titulo = "Kotlin 4", autor = "Diego Cano", anioDePublicacion = 2023, tematica = "Crimen"),
        Libro(titulo = "Kotlin 5", autor = "Diego Cano", anioDePublicacion = 2023, tematica = "Horror"),
        Libro(titulo = "Kotlin 6", autor = "Diego Cano", anioDePublicacion = 2023, tematica = "Historia"),
    Libro(titulo = "SQL 1", autor = "Tomas Coronado", anioDePublicacion = 2023, tematica = "Realismo mágico")
    )
    val listaUsuarios = listOf(
        Usuario(nombre = "Manuel"),
        Usuario(nombre = "Jose"),
        Usuario(nombre = "Paco"),
        Usuario(nombre = "Mercedes"),
        Usuario(nombre = "Pedro")
    )
    val biblioteca = Biblioteca(GestorConsola(), GestorBiblioteca(RegistroPrestamos(), Catalogo(GestorElementos())), listaLibros, listaUsuarios)

    biblioteca.iniciar()
}