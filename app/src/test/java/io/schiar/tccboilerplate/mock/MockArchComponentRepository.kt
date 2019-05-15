package io.schiar.tccboilerplate.mock

import io.schiar.tccboilerplate.model.ArchComponent
import io.schiar.tccboilerplate.model.Library
import io.schiar.tccboilerplate.model.repository.ArchComponentRepositoryInterface

class MockArchComponentRepository : ArchComponentRepositoryInterface {
    override fun fetch(callback: (List<ArchComponent>) -> Unit) {
        val archComponent = ArchComponent(
            "Mock",
            """Serve para simular de forma síncrona e isolada o comportamento de uma classe real.
                Utilizar uma classe real no teste muitas vezes é impraticável pois alguns dos seus métodos
                podem ser assíncronos e dependentes de componentes externos como rede ou banco de dados.
                Embora alguns mocks possam ser criados na mão, mocks genéricos podem facilmente ser criados
                utilizando o framework Mockito.""",
            Library("org.mockito:mockito-core", listOf(2, 27, 0))
        )
        callback(listOf(archComponent))
    }
}