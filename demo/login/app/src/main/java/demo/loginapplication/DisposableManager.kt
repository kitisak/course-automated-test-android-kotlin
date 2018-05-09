package demo.loginapplication

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

object DisposableManager {
    val comcompositeDisposable: CompositeDisposable = CompositeDisposable()

    fun add(disposable: Disposable) {
        comcompositeDisposable.add(disposable)
    }

    fun clear() {
        comcompositeDisposable.clear()
    }


}