package io.schiar.tccboilerplate.model.repository

import io.schiar.tccboilerplate.model.ArchComponent
import io.schiar.tccboilerplate.model.Library

/**
 * Implementação de um repository de componentes arquiteturais. Fornece os dados a respeito dos
 * componentes arquiteturais.
 *
 * Por motivos de simplificação, essa classe gera dados de componentes arquiteturais para a aplicação
 * e os mantém em memória durante a execução. Numa aplicação real, essa classe se comunicaria
 * com as diferentes camadas de dados da aplicação, como por exemplo serviços e persistência.
 *
 * @property archComponents componentes arquiteturais gerados para serem exibidos na lista de componentes arquiteturais.
 * Numa aplicação real, esses objetos viriam de uma camada de dados da aplicação.
 */
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

    /**
     * Busca a lista de componentes arquiteturais a ser exibida na View.
     * @param callback usado para receber a lista de componentes arquiteturais buscada.
     */
    override fun fetch(callback: (List<ArchComponent>) -> Unit) {
        return callback(archComponents)
    }

}