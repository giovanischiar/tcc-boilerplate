package io.schiar.tccboilerplate.model

/**
 * Representa um componente arquitetural.
 * @property name nome do componente.
 * @property description descrição do componente.
 * @property library biblioteca do componente.
 */
data class ArchComponent(
    val name: String,
    val description: String,
    val library: Library
)