package demo.loginapplication

import android.app.Activity
import android.content.Context
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.RootMatchers
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers

class LoginRobot(val activity: Activity){

    fun setEmail(email: String) = apply { fillEditText(R.id.email, email) }
    fun setPassword(password: String) = apply { fillEditText(R.id.password, password) }
    fun clickLogin() = apply { clickButton(R.id.email_sign_in_button) }
    fun mustShow(text: String) = apply { toast(text) }

    private fun sleep()= apply {
        Thread.sleep(500)
    }


    private fun fillEditText(resId: Int, text: String): ViewInteraction =
            onView(withId(resId))
                    .perform(ViewActions.replaceText(text),
                             ViewActions.closeSoftKeyboard())

    private fun clickButton(resId: Int): ViewInteraction =
            onView((withId(resId))).perform(ViewActions.click())

    private fun matchText(viewInteraction: ViewInteraction, text: String): ViewInteraction = viewInteraction
            .check(ViewAssertions.matches(ViewMatchers.withText(text)))

    private fun toast(text: String) = onView(ViewMatchers.withText(text))
            .inRoot(RootMatchers.withDecorView(Matchers.not(activity.window.decorView)))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

}