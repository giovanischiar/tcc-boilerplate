package io.schiar.tccboilerplate.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Recebe mensagens da visão solicitando dados.
 * Formata esses dados e os disponibiliza para a visão através dos objetos LiveData.
 * @property helloWorld usado no XML para ser mostrado na tela.
 */
class OtherViewModel: ViewModel() {
    val helloWorld = MutableLiveData<String>().apply { value = "HelloWorld" }

    /* TODO: Criar LiveDatas, ver exemplo em BoilerplateViewModels */
}