package io.schiar.tccboilerplate

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.schiar.tccboilerplate.mock.GenericMockFactory.Companion.mock
import io.schiar.tccboilerplate.mock.MockArchComponentRepository
import io.schiar.tccboilerplate.view.viewdata.ArchComponentViewData
import io.schiar.tccboilerplate.view.viewdata.LibraryViewData
import io.schiar.tccboilerplate.viewmodel.BoilerplateViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.verify

/**
 * Testa o [BoilerplateViewModel]
 * @property rule permite-se utilizar LiveData no JUnit.
 * @property archComponentViewData usado para verificar se buscando os componentes arquitetuais do repositório mock
 * retorna um igual a esse.
 * @property boilerplateViewModel usado para testar todos os testes da classe.
 */
class BoilerplateViewModelUnitTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val archComponentViewData = ArchComponentViewData(
        "Mock",
        """Serve para simular de forma síncrona e isolada o comportamento de uma classe real.
                Utilizar uma classe real no teste muitas vezes é impraticável pois alguns dos seus métodos
                podem ser assíncronos e dependentes de componentes externos como rede ou banco de dados.
                Embora alguns mocks possam ser criados na mão, mocks genéricos podem facilmente ser criados
                utilizando o framework Mockito.""",
        LibraryViewData("org.mockito:mockito-core", "2.27.0")
    )

    private lateinit var boilerplateViewModel: BoilerplateViewModel

    /**
     * Executa antes de todos os testes. Cria-se um [BoilerplateViewModel] passando como parâmetro um repositório mock.
     */
    @Before
    fun prepare() {
        boilerplateViewModel = BoilerplateViewModel(MockArchComponentRepository())
    }

    /**
     * Verifica se o atributo archComponents de [boilerplateViewModel] é inicializado com null.
     */
    @Test
    fun archComponents_isInitiallyNull() {
        assertNull(boilerplateViewModel.archComponents.value)
    }

    /**
     * Verifica se o componente buscado no repository definido no construtor chamando fetch de [boilerplateViewModel]
     * ele atualiza o [boilerplateViewModel]
     */
    @Test
    fun fetch_archComponentsPostsCorrectArchComponentViewData() {
        val observer: Observer<List<ArchComponentViewData>> = mock()
        boilerplateViewModel.archComponents.observeForever(observer)

        boilerplateViewModel.fetch()
        verify(observer).onChanged(listOf(archComponentViewData))
    }

    /**
     * Verifica se o componente buscado no repository definido no construtor chamando fetch é igual ao
     * [archComponentViewData]
     */
    @Test
    fun fetch_archComponentsContainsCorrectArchComponentViewData() {
        boilerplateViewModel.fetch()
        assertEquals(listOf(archComponentViewData), boilerplateViewModel.archComponents.value)
    }
}