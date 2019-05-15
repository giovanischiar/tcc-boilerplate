package io.schiar.tccboilerplate.model.repository

import io.schiar.tccboilerplate.model.ArchComponent
import io.schiar.tccboilerplate.model.Library

class ArchComponentRepository: ArchComponentRepositoryInterface {
    private val archComponents = listOf(
        ArchComponent("Data Binding",
                      "Serve para o XML da view ter acesso direto ao View Model",
                       Library("com.android.databinding:compiler", listOf(3, 3, 2))
        ),

        ArchComponent("ViewModel",
            "Componente que carrega os dados para serem escritos na View",
            Library("androidx.lifecycle:lifecycle-viewmodel-ktx", listOf(2, 0, 0))
        ))

    override fun fetch(callback: (List<ArchComponent>) -> Unit) {
        return callback(archComponents)
    }

}