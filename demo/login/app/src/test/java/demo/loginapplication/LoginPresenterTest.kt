package demo.loginapplication

import android.accounts.NetworkErrorException
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.verify
import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.MockitoAnnotations

class LoginPresenterTest {

    lateinit var loginPresenter: LoginPresenter
    lateinit var loginRepositoryStub: LoginRepository
    lateinit var loginViewMock: LoginView

    @Before @Throws
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler({ Schedulers.trampoline()})
        MockitoAnnotations.initMocks(this)

        loginRepositoryStub = mock(LoginRepository::class.java)
        loginViewMock = mock(LoginView::class.java)

        loginPresenter = LoginPresenter(loginRepositoryStub, loginViewMock)
    }

    @Test
    fun tryToLogin_success() {
        given(loginRepositoryStub.authenticate("somkiat@xxx.com", "password"))
                .willReturn(Observable.just(User(1, "somkiat", "xxx")))

        loginPresenter.tryToLogin("somkiat@xxx.com", "password")

        verify(loginViewMock).showResult("Hello somkiat")
    }

    @Test
    fun tryToLogin_error() {
        given(loginRepositoryStub.authenticate("", ""))
                .willReturn(Observable.error(NetworkErrorException()))

        loginPresenter.tryToLogin("", "")

        verify(loginViewMock, never()).showResult("Hello")
    }
}