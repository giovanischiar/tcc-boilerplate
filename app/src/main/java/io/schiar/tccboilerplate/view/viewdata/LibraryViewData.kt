package io.schiar.tccboilerplate.view.viewdata

data class LibraryViewData(
    val name: String,
    val version: String
)

fun LibraryViewData.canonicalName(): String {
    return "$name:$version"
}