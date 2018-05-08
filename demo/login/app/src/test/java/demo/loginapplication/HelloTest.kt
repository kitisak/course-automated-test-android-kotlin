package demo.loginapplication

import org.junit.Assert.assertEquals
import org.junit.Test

class HelloTest {

    @Test
    fun `login success with correct email and password`() {
        // Arrange or Given
        val hello = Hello()

        // Act or When
        val actualResult = hello.sayHi("somkiat")

        // Assert or Then
        assertEquals("Hi, somkiat", actualResult)
    }

}

