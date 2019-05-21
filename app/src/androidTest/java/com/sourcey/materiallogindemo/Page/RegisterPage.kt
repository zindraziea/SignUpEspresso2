package com.sourcey.materiallogindemo.Page

import android.support.test.espresso.Espresso

import com.sourcey.materiallogindemo.R

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.scrollTo
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

class RegisterPage {
    @Throws(InterruptedException::class)
    fun inputRegisterInfoAndSignUpSuccess(name: String, address: String, email: String, mobile: String, password: String, confirmPassword: String): RegisterSuccessPage {
        inputRegisterInfoAndSignUp(name, address, email, mobile, password, confirmPassword)
        return RegisterSuccessPage()
    }

    @Throws(InterruptedException::class)
    fun inputRegisterInfoAndSignUpFail(name: String, address: String, email: String, mobile: String, password: String, confirmPassword: String) {
        inputRegisterInfoAndSignUp(name, address, email, mobile, password, confirmPassword)
    }

    fun inputRegisterInfoAndSignUp(name: String, address: String, email: String, mobile: String, password: String, confirmPassword: String) {
        onView(withId(R.id.input_name)).check(matches(isDisplayed())).perform(typeText(name))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.input_address)).check(matches(isDisplayed())).perform(typeText(address))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.input_email)).check(matches(isDisplayed())).perform(typeText(email))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.input_mobile)).check(matches(isDisplayed())).perform(typeText(mobile))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.input_password)).check(matches(isDisplayed())).perform(typeText(password))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.input_reEnterPassword)).perform(scrollTo()).check(matches(isDisplayed())).perform(typeText(confirmPassword))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btn_signup)).check(matches(isDisplayed())).perform(click())
    }


}
