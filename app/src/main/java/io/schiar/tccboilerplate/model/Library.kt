package io.schiar.tccboilerplate.model

/**
 * Representa uma biblioteca.
 * @property name nome da biblioteca.
 * @property version versão da biblioteca.
 */
data class Library(
    val name: String,
    val version: List<Int>
)