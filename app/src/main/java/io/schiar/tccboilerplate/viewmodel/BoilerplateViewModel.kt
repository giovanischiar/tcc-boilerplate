package io.schiar.tccboilerplate.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.schiar.tccboilerplate.model.ArchComponent
import io.schiar.tccboilerplate.model.repository.ArchComponentRepository
import io.schiar.tccboilerplate.model.repository.ArchComponentRepositoryInterface
import io.schiar.tccboilerplate.view.viewdata.ArchComponentViewData
import io.schiar.tccboilerplate.view.viewdata.LibraryViewData

class BoilerplateViewModel(
    private val archComponentRepository: ArchComponentRepositoryInterface = ArchComponentRepository()
) : ViewModel() {

    val archComponents: MutableLiveData<List<ArchComponentViewData>> by lazy {
        MutableLiveData<List<ArchComponentViewData>>()
    }

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
