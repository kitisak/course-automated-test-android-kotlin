package demo.loginapplication

import io.reactivex.Observable

open class LoginRepository(val loginService: LoginService) {

    fun authenticate(email: String, password: String): Observable<User> {
        return loginService.login()
    }

}