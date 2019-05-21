package com.sourcey.materiallogindemo.Page

import android.support.test.espresso.Espresso

import com.sourcey.materiallogindemo.R

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

class LoginPage : BasePage() {
    fun goToRegisterPage(): RegisterPage {
        onView(withId(R.id.link_signup)).check(matches(isDisplayed())).perform(click())
        return RegisterPage()
    }

    @Throws(InterruptedException::class)
    fun VerifyObjectOnLoginPage() {
        Thread.sleep(1000)
        onView(withText("Email")).check(matches(isDisplayed()))
        onView(withId(R.id.input_email)).check(matches(isDisplayed()))
        onView(withText("Password")).check(matches(isDisplayed()))
        onView(withId(R.id.input_password)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()))
        onView(withId(R.id.link_signup)).check(matches(isDisplayed()))
    }

    @Throws(InterruptedException::class)
    fun inputLoginPageAndLogin(email: String, password: String) {
        Thread.sleep(1000)
        onView(withId(R.id.input_email)).check(matches(isDisplayed())).perform(typeText(email))
        onView(withId(R.id.input_password)).check(matches(isDisplayed())).perform(typeText(password))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click())
    }
}

