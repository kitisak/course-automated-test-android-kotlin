package demo.hello

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class ValidateInputFail2Test(val email: String
                             , val password: String
                             , val name: String) {

    companion object {
        @JvmStatic
        @Parameters(name = "{index}: validate_case{2}({0}, {1})")
        fun data(): List<Array<String>> {
            return listOf(
                    arrayOf("", "password", "Empty email"),
                    arrayOf("somkiat@xxx.com", "", "Empty password")
            )
        }
    }

    @Test
    fun xxx() {
        // Arrange or Given
        val validateInput = ValidateInput()

        // Act or When
        val actualResult
                = validateInput.validate(email, password)

        // Assert or Then
        Assert.assertFalse(actualResult)
    }

}