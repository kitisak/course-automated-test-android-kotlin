package demo.loginapplication

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import demo.loginapplication.screen.TestLoginScreen
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    @get:Rule
    val rule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)


    @Test
    fun success() {
        onView(withId(R.id.email)).perform(
                replaceText("somkiat@xxx.com"),
                closeSoftKeyboard())

        onView(withId(R.id.password)).perform(
                replaceText(""),
                closeSoftKeyboard())

        onView(withId(R.id.email_sign_in_button)).perform(click())

        onView(withText("Success"))
                .inRoot(withDecorView(not(rule.activity.window.decorView)))
                .check(matches(isDisplayed()))

    }

    private lateinit var robot: LoginRobot
    private lateinit var screen: TestLoginScreen

    @Before
    fun setup() {
        robot = LoginRobot(rule.activity)
        screen = TestLoginScreen()
    }

    @Test
    fun success_with_robot() {
        robot
                .setEmail("somkiat@xxx.com")
                .setPassword("")
                .clickLogin()
                .mustShow("Success")
    }

    @Test
    fun success_with_kakao() {
        screen {
            email {
                replaceText("somkiat@xxx.com")
            }
            password {
                replaceText("")
            }
            login {
                click()
            }
        }
        onView(withText("Success"))
                .inRoot(withDecorView(not(rule.activity.window.decorView)))
                .check(matches(isDisplayed()))
    }

}
