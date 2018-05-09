package demo.hello

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Rule

class MainActivityTest {

    @get:Rule
    val rule: ActivityTestRule<MainActivity> =
            ActivityTestRule(MainActivity::class.java,
                    false,
                    false)

    @Test @Ignore
    fun success_with_kakao() {
        rule.launchActivity(null);

        val loginScreen = LoginScreen()

        loginScreen {
            email {
                replaceText("somkiat@xxx.com")
            }
            password {
                replaceText("password")
            }
            login {
                click()
                closeSoftKeyboard()
            }
            result {
                hasText("Success")
            }
        }

    }

    @Test @Ignore
    fun success_with_robot() {
        rule.launchActivity(null);
        val robot = LoginRobot()

        robot
                .fillinEmail("somkiat@xxx.com")
                .fillinPassword("password")

        robot.apply {
            fillinEmail("somkiat@xxx.com")
            fillinPassword("password")
        }
    }

    @Test @Ignore
    fun success() {
        rule.launchActivity(null);
        onView(withId(R.id.result))
                .check(matches(withText("TODO")))

        onView(withId(R.id.email)).perform(
                replaceText("somkiat@xxx.com"),
                closeSoftKeyboard()
        )

        onView(withId(R.id.password)).perform(
                replaceText("password"),
                closeSoftKeyboard()
        )

        onView(withId(R.id.login)).perform(
                click()
        )

        onView(withId(R.id.result))
                .check(matches(withText("Login success")))
    }
}