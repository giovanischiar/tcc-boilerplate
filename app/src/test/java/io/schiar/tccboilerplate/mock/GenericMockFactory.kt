package io.schiar.tccboilerplate.mock

import org.mockito.Mockito

/**
 * Criação de mocks.
 */
class GenericMockFactory {
    /**
     * Cria mocks onde é possível utilizar classes que recebem parâmetros de tipo (generics).
     * @return apenas ignora o parâmetro de tipo e chama o mock da biblioteca Mockito.
     */
    companion object {
        inline fun <reified T> mock(): T {
            return Mockito.mock(T::class.java)
        }
    }
}