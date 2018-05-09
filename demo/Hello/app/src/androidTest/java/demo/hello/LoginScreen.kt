package demo.hello

import com.agoda.kakao.KButton
import com.agoda.kakao.KEditText
import com.agoda.kakao.KTextView
import com.agoda.kakao.Screen

class LoginScreen: Screen<LoginScreen>() {

    val email = KEditText { withId(R.id.email) }
    val password = KEditText { withId(R.id.password) }
    val login = KButton { withId(R.id.login) }
    val result = KTextView { withId(R.id.result)}

}