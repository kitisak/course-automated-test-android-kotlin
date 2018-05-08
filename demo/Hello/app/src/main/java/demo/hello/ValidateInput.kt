package demo.hello

class ValidateInput {

    fun validate(email: String, password: String): Boolean {
        if (email == "") {
            return false
        }
        if (password == "") {
            return false
        }
        return true
    }

}
