package com.sourcey.materiallogindemo.Keyword.screen

import android.support.test.espresso.Espresso.closeSoftKeyboard

import com.sourcey.materiallogindemo.R

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.scrollTo
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

class RegisterScreen : BaseScreen() {

    val txtInputName: ViewInteraction = onView(withId(R.id.input_name))
    val txtInputAddress: ViewInteraction = onView(withId(R.id.input_address))
    val txtInputEmail: ViewInteraction = onView(withId(R.id.input_email))
    val txtInputMobile: ViewInteraction = onView(withId(R.id.input_mobile))
    val txtInputPassword: ViewInteraction = onView(withId(R.id.input_password))
    val txtInputReEnterPassword: ViewInteraction = onView(withId(R.id.input_reEnterPassword))
    val btnSignUp: ViewInteraction = onView(withId(R.id.btn_signup))

    fun iInputName(name: String) {
        txtInputName.check(matches(isDisplayed())).perform(typeText(name))
        closeSoftKeyboard()
    }

    fun iInputAddress(address: String) {
        txtInputAddress.check(matches(isDisplayed())).perform(typeText(address))
        closeSoftKeyboard()
    }

    fun iInputEmail(email: String) {
        txtInputEmail.check(matches(isDisplayed())).perform(typeText(email))
        closeSoftKeyboard()
    }

    fun iInputMobile(mobile: String) {
        txtInputMobile.check(matches(isDisplayed())).perform(typeText(mobile))
        closeSoftKeyboard()
    }

    fun iInputPassword(password: String) {
        txtInputPassword.check(matches(isDisplayed())).perform(typeText(password))
        closeSoftKeyboard()
    }

    fun iInputReEnterPassword(confirmPassword: String) {
        txtInputReEnterPassword.perform(scrollTo()).check(matches(isDisplayed())).perform(typeText(confirmPassword))
        closeSoftKeyboard()
    }

    fun iClickBtnSignUp() {
        btnSignUp.check(matches(isDisplayed())).perform(click())
    }

}
