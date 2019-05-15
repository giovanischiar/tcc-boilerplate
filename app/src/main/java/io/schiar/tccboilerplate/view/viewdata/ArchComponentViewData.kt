package io.schiar.tccboilerplate.view.viewdata

/**
 * Representação dos componentes arquiteturais do ponto de vista da visão.
 * @property name nome de um componente.
 * @property description descrição de um componente.
 * @property library biblioteca de um componente.
 */
data class ArchComponentViewData(
    val name: String,
    val description: String,
    val library: LibraryViewData
)