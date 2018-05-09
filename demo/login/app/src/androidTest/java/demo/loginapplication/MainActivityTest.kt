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
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    @get:Rule
    val rule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)


    @Test @Ignore
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

    private lateinit var loginPage: LoginRobot
    private lateinit var welcomePage: LoginRobot
    private lateinit var screen: TestLoginScreen

    @Before
    fun setup() {
        loginPage = LoginRobot(rule.activity)
        welcomePage = LoginRobot(rule.activity)
        screen = TestLoginScreen()
    }

    @Test @Ignore
    fun success_with_robot() {
        loginPage
                .setEmail("somkiat@xxx.com")
                .setPassword("")
                .clickLogin()
                .mustShow("Success")

        welcomePage
                .setEmail("somkiat@xxx.com")
                .setPassword("")
    }

    @Test @Ignore
    fun success_with_kakao() {
        screen {
            email {
                replaceText("somkiat@xxx.com")
                closeSoftKeyboard()
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
