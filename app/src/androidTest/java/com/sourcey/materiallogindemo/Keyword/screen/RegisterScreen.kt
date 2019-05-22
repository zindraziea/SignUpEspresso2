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
import com.sourcey.materiallogindemo.utility.VerifyTextEditUtility

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

class RegisterScreen : BaseScreen() {

    private val txtInputName: ViewInteraction by lazy {onView(withId(R.id.input_name))}
    private val txtInputAddress: ViewInteraction by lazy {onView(withId(R.id.input_address))}
    private val txtInputEmail: ViewInteraction by lazy {onView(withId(R.id.input_email))}
    private val txtInputMobile: ViewInteraction by lazy {onView(withId(R.id.input_mobile))}
    private val txtInputPassword: ViewInteraction by lazy {onView(withId(R.id.input_password))}
    private val txtInputReEnterPassword: ViewInteraction by lazy {onView(withId(R.id.input_reEnterPassword))}
    private val btnSignUp: ViewInteraction by lazy {onView(withId(R.id.btn_signup))}
    private val verifyTextEdit by lazy {VerifyTextEditUtility()}

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

    fun iVerifyNameError(errorMessage: String?) {
        verifyTextEdit.verifyTextErrorMessage(txtInputName, errorMessage)
    }

    fun iVerifyAddress(errorMessage: String?) {
        verifyTextEdit.verifyTextErrorMessage(txtInputAddress, errorMessage)
    }

    fun iVerifyEmail(errorMessage: String?) {
        verifyTextEdit.verifyTextErrorMessage(txtInputEmail, errorMessage)
    }

    fun iVerifyMobile(errorMessage: String?) {
        verifyTextEdit.verifyTextErrorMessage(txtInputMobile, errorMessage)
    }

    fun iVerifyPassword(errorMessage: String?) {
        verifyTextEdit.verifyTextErrorMessage(txtInputPassword, errorMessage)
    }

    fun iVerifyReEnterPassword(errorMessage: String?) {
        verifyTextEdit.verifyTextErrorMessage(txtInputReEnterPassword, errorMessage)
    }

}
