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
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.locale.LocaleTestRule


class MainActivityUITest {

    @get:Rule
    val rule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @get:Rule
    val local: LocaleTestRule = LocaleTestRule();


    @Test
    fun success() {
        Screengrab.screenshot("step01");

        onView(withId(R.id.email)).perform(
                replaceText("somkiat@xxx.com"),
                closeSoftKeyboard())

        onView(withId(R.id.password)).perform(
                replaceText(""),
                closeSoftKeyboard())

        Screengrab.screenshot("step02");

        onView(withId(R.id.email_sign_in_button)).perform(click())

        Screengrab.screenshot("step03");

        onView(withText("Success"))
                .inRoot(withDecorView(not(rule.activity.window.decorView)))
                .check(matches(isDisplayed()))
    }

}
