package io.schiar.tccboilerplate.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.schiar.tccboilerplate.model.ArchComponent
import io.schiar.tccboilerplate.model.repository.ArchComponentRepository
import io.schiar.tccboilerplate.model.repository.ArchComponentRepositoryInterface
import io.schiar.tccboilerplate.view.viewdata.ArchComponentViewData
import io.schiar.tccboilerplate.view.viewdata.LibraryViewData

/**
 * Recebe mensagens da visão solicitando dados.
 * Formata esses dados e os disponibiliza para a visão através dos objetos LiveData.
 * @property archComponentRepository fornecedor de objetos de modelo para o ViewModel.
 * @property archComponents lista atual de componentes arquiteturais.
 * @property buttonContent conteúdo do botão da tela.
 */
class BoilerplateViewModel(
    private val archComponentRepository: ArchComponentRepositoryInterface = ArchComponentRepository()
) : ViewModel() {

    val archComponents: MutableLiveData<List<ArchComponentViewData>> by lazy {
        MutableLiveData<List<ArchComponentViewData>>()
    }

    val buttonContent = MutableLiveData<String>().apply { value = "Exemplo de navegação" }

    /**
     * Busca os dados de componentes arquiteturais e atualiza o LiveData de [archComponents].
     */
    fun fetch() {
        archComponentRepository.fetch {
            archComponents.postValue(it.map {archComponent: ArchComponent ->
                ArchComponentViewData(
                    archComponent.name,
                    archComponent.description,
                    LibraryViewData(
                        archComponent.library.name,
                        archComponent.library.version.joinToString(".")
                    )
                )
            })
        }
    }
}
