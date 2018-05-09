package demo.loginapplication

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class LoginPresenter(val loginRepository: LoginRepository, val loginView: LoginView) {

    fun tryToLogin(email: String, password: String) {
        val disposable = loginRepository.authenticate(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableObserver<User>(){
                    override fun onComplete() {
                        // Do something
                    }

                    override fun onNext(user: User) {
                        //Call back
                        loginView.showResult("Hello ${user.name}")
                    }

                    override fun onError(e: Throwable) {
                        // Do something
                    }

                })
        DisposableManager.add(disposable)
    }

}