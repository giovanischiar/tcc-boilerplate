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
 * Local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
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

    @Before
    fun prepare() {
        boilerplateViewModel = BoilerplateViewModel(MockArchComponentRepository())
    }

    @Test
    fun archComponents_isInitiallyNull() {
        assertNull(boilerplateViewModel.archComponents.value)
    }

    @Test
    fun fetch_archComponentsPostsCorrectArchComponentViewData() {
        val observer: Observer<List<ArchComponentViewData>> = mock()
        boilerplateViewModel.archComponents.observeForever(observer)

        boilerplateViewModel.fetch()
        verify(observer).onChanged(listOf(archComponentViewData))
    }

    @Test
    fun fetch_archComponentsContainsCorrectArchComponentViewData() {
        boilerplateViewModel.fetch()
        assertEquals(listOf(archComponentViewData), boilerplateViewModel.archComponents.value)
    }
}