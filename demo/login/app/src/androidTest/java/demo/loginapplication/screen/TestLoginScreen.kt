package demo.loginapplication.screen

import com.agoda.kakao.KButton
import com.agoda.kakao.KEditText
import com.agoda.kakao.Screen
import demo.loginapplication.R

open class TestLoginScreen: Screen<TestLoginScreen>() {

    val email: KEditText = KEditText { withId(R.id.email)}
    val password: KEditText = KEditText { withId(R.id.password)}
    val login: KButton = KButton { withId(R.id.email_sign_in_button) }

}