package com.sourcey.materiallogindemo.Page

import android.support.test.espresso.Espresso.closeSoftKeyboard

import com.sourcey.materiallogindemo.R

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
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

    val lnkSignUp: ViewInteraction = onView(withId(R.id.link_signup))
    val txtEmail: ViewInteraction = onView(withText("Email"))
    val txtInputEmail: ViewInteraction = onView(withId(R.id.input_email))
    val txtPassword: ViewInteraction = onView(withText("Password"))
    val txtInputPassword: ViewInteraction = onView(withId(R.id.input_password))
    val btnLogin: ViewInteraction = onView(withId(R.id.btn_login))

    fun goToRegisterPage() {
        lnkSignUp.check(matches(isDisplayed())).perform(click())
    }

    @Throws(InterruptedException::class)
    fun VerifyObjectOnLoginPage() {
        isVisible(txtInputEmail,1000)
        txtEmail.check(matches(isDisplayed()))
        txtInputEmail.check(matches(isDisplayed()))
        txtPassword.check(matches(isDisplayed()))
        txtInputPassword.check(matches(isDisplayed()))
        btnLogin.check(matches(isDisplayed()))
        lnkSignUp.check(matches(isDisplayed()))
    }

    @Throws(InterruptedException::class)
    fun inputLoginPageAndLogin(email: String, password: String) {
        isVisible(txtInputEmail,1000)
        txtInputEmail.check(matches(isDisplayed())).perform(typeText(email))
        txtInputPassword.check(matches(isDisplayed())).perform(typeText(password))
        closeSoftKeyboard()
        btnLogin.check(matches(isDisplayed())).perform(click())
    }
}

