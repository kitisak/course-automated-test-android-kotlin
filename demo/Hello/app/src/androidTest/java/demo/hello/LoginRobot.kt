package demo.hello

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.closeSoftKeyboard
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.matcher.ViewMatchers.withId

class LoginRobot {
    fun fillinEmail(email: String) = apply { xxx(email, R.id.email) }
    fun fillinPassword(password: String) = apply { xxx(password, R.id.email) }

    private fun xxx(text: String, id: Int) {
        onView(withId(id)).perform(
                replaceText(text),
                closeSoftKeyboard()
        )
    }
}