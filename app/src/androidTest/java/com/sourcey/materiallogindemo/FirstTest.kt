package com.sourcey.materiallogindemo.test

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import com.sourcey.materiallogindemo.MainActivity
import com.sourcey.materiallogindemo.R

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@RunWith(AndroidJUnit4::class)
class FirstTest {

    @Rule @JvmField
    val mActivityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun FirstTest001() {
        onView(withId(R.id.link_signup)).check(matches(isDisplayed())).perform(click())
        sleep(1000)
        onView(withId(R.id.input_name)).check(matches(isDisplayed()))
    }
}

