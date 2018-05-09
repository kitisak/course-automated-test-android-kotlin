package demo.loginapplication

import io.reactivex.Observable
import retrofit2.http.GET

interface LoginService {

    @GET("/users/1")
    fun login(): Observable<User>

}