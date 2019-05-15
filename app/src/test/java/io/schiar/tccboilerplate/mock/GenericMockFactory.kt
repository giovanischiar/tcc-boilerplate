package io.schiar.tccboilerplate.mock

import org.mockito.Mockito

class GenericMockFactory {
    companion object {
        inline fun <reified T> mock(): T {
            return Mockito.mock(T::class.java)
        }
    }
}