package io.schiar.tccboilerplate.view.viewdata

/**
 * Representação das bibliotecas do ponto de vista da visão.
 * @property name nome de uma biblioteca.
 * @property version versão de uma biblioteca.
 */
data class LibraryViewData(
    val name: String,
    val version: String
)

/**
 * Método auxiliar para gerar um nome completo da biblioteca.
 * @return o nome completo da biblioteca.
 */
fun LibraryViewData.canonicalName(): String {
    return "$name:$version"
}