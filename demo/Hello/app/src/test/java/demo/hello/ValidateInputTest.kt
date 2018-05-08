package demo.hello

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidateInputTest {

    @Test
    fun `password ว่างจะไม่ผ่านนะ`(){
        // Arrange or Given
        val validateInput = ValidateInput()

        // Act or When
        val actualResult
                = validateInput.validate("somkiat@xxx.com", "")

        // Assert or Then
        assertFalse("เพราะว่า password ว่างต้องไม่ผ่าน", actualResult)
    }

    @Test
    fun `email ว่างจะไม่ผ่านนะ`(){
        // Arrange or Given
        val validateInput = ValidateInput()

        // Act or When
        val actualResult
                = validateInput.validate("", "pass")

        // Assert or Then
        assertFalse("เพราะว่า email ว่างต้องไม่ผ่าน", actualResult)
    }

    @Test
    fun `email และ password ถูกต้องทั้งคู่`(){
        // Arrange or Given
        val validateInput = ValidateInput()

        // Act or When
        val actualResult
                = validateInput.validate("somkiat@xxx.com", "pass")

        // Assert or Then
        assertTrue(actualResult)
    }

}