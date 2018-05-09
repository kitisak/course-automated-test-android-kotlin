package demo.hello

import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.locale.LocaleTestRule
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy



class MainActivityScreengrabTest {

    @get:Rule
    val rule: ActivityTestRule<MainActivity> =
            ActivityTestRule(MainActivity::class.java)

    @get:Rule
    val local: LocaleTestRule = LocaleTestRule()

    @Test
    fun success_flow() {

        Screengrab.setDefaultScreenshotStrategy(UiAutomatorScreenshotStrategy())

        Screengrab.screenshot("step01")

        onView(withId(R.id.result)).check(matches(withText("TODO")))

        onView(withId(R.id.email)).perform(replaceText("somkiat@xxx.com"))

        onView(withId(R.id.password)).perform(replaceText("password"))

        Screengrab.screenshot("step02")

        onView(withId(R.id.login)).perform(click())

        Screengrab.screenshot("step03")

        onView(withId(R.id.result)).check(matches(withText("Login success")))
    }

}