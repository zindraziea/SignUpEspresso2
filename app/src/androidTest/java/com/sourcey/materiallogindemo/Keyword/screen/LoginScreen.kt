package com.sourcey.materiallogindemo.Keyword.screen

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
import com.sourcey.materiallogindemo.utility.VerifyTextEditUtility

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

class LoginScreen : BaseScreen() {

    private val verifyTextEdit by lazy {VerifyTextEditUtility()}
    private val btnSignUp: ViewInteraction by lazy {onView(withId(R.id.link_signup))}
    private val txtEmail: ViewInteraction by lazy {onView(withText("Email"))}
    private val txtInputEmail: ViewInteraction by lazy {onView(withId(R.id.input_email))}
    private val txtPassword: ViewInteraction by lazy {onView(withText("Password"))}
    private val txtInputPassword: ViewInteraction by lazy {onView(withId(R.id.input_password))}
    private val btnLogin: ViewInteraction by lazy {onView(withId(R.id.btn_login))}

    fun iClickBtnRegister() {
        btnSignUp.check(matches(isDisplayed())).perform(click())
    }

    fun iCanSeeLoginScreen() {
        isVisible(txtInputEmail, 1000)
    }

    fun iVerifyTxtEmailShouldbeDisplayed() {
        txtEmail.check(matches(isDisplayed()))
    }

    fun iVerifyTxtInputEmailShouldbeDisplayed() {
        txtInputEmail.check(matches(isDisplayed()))
    }

    fun iInputEmail(email: String) {
        txtInputEmail.check(matches(isDisplayed())).perform(typeText(email))
        closeSoftKeyboard()
    }

    fun iVerifyTxtPasswordShouldbeDisplayed() {
        txtPassword.check(matches(isDisplayed()))
    }

    fun iVerifyTxtInputPasswordShouldbeDisplayed() {
        txtInputPassword.check(matches(isDisplayed()))
    }

    fun iInputPassword(password: String) {
        txtInputPassword.check(matches(isDisplayed())).perform(typeText(password))
        closeSoftKeyboard()
    }

    fun iVerifyBtnLoginShouldbeDisplayed() {
        btnLogin.check(matches(isDisplayed()))
    }

    fun iClickBtnLogin() {
        btnLogin.check(matches(isDisplayed())).perform(click())
    }

    fun iVerifyBtnSignUpShouldbeDisplayed() {
        btnSignUp.check(matches(isDisplayed()))
    }

    fun iVerifyLoginError(errorMessage: String?) {
        verifyTextEdit.verifyTextErrorMessage(txtInputEmail, errorMessage)
    }

    fun iVerifyPasswordError(errorMessage: String?) {
        verifyTextEdit.verifyTextErrorMessage(txtInputPassword, errorMessage)
    }

}

