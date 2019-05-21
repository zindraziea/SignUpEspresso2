package com.sourcey.materiallogindemo.Page

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

class RegisterPage : BasePage() {

    val txtInputName: ViewInteraction = onView(withId(R.id.input_name))
    val txtInputAddress: ViewInteraction = onView(withId(R.id.input_address))
    val txtInputEmail: ViewInteraction = onView(withId(R.id.input_email))
    val txtInputMobile: ViewInteraction = onView(withId(R.id.input_mobile))
    val txtInputPassword: ViewInteraction = onView(withId(R.id.input_password))
    val txtInputReEnterPassword: ViewInteraction = onView(withId(R.id.input_reEnterPassword))
    val btnSignUp: ViewInteraction = onView(withId(R.id.btn_signup))

    @Throws(InterruptedException::class)
    fun inputRegisterInfoAndSignUpSuccess(name: String, address: String, email: String, mobile: String, password: String, confirmPassword: String) {
        inputRegisterInfoAndSignUp(name, address, email, mobile, password, confirmPassword)
    }

    @Throws(InterruptedException::class)
    fun inputRegisterInfoAndSignUpFail(name: String, address: String, email: String, mobile: String, password: String, confirmPassword: String) {
        inputRegisterInfoAndSignUp(name, address, email, mobile, password, confirmPassword)
    }

    fun inputRegisterInfoAndSignUp(name: String, address: String, email: String, mobile: String, password: String, confirmPassword: String) {
        txtInputName.check(matches(isDisplayed())).perform(typeText(name))
        closeSoftKeyboard()
        txtInputAddress.check(matches(isDisplayed())).perform(typeText(address))
        closeSoftKeyboard()
        txtInputEmail.check(matches(isDisplayed())).perform(typeText(email))
        closeSoftKeyboard()
        txtInputMobile.check(matches(isDisplayed())).perform(typeText(mobile))
        closeSoftKeyboard()
        txtInputPassword.check(matches(isDisplayed())).perform(typeText(password))
        closeSoftKeyboard()
        txtInputReEnterPassword.perform(scrollTo()).check(matches(isDisplayed())).perform(typeText(confirmPassword))
        closeSoftKeyboard()
        btnSignUp.check(matches(isDisplayed())).perform(click())
    }


}
