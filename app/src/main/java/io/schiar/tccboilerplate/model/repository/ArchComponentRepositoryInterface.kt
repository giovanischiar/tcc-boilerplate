package io.schiar.tccboilerplate.model.repository

import io.schiar.tccboilerplate.model.ArchComponent

interface ArchComponentRepositoryInterface {
    fun fetch(callback: (List<ArchComponent>) -> Unit )
}