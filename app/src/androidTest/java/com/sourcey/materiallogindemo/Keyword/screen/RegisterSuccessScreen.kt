package com.sourcey.materiallogindemo.Keyword.screen

import com.sourcey.materiallogindemo.R
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

class RegisterSuccessScreen : BaseScreen() {

    private val txtSignupSuccess: ViewInteraction by lazy {onView(withText("Hello world!"))}
    private val btnLogOut: ViewInteraction by lazy {onView(withId(R.id.btn_logout))}

    fun iCanSeeSignUpSuccessScreen() {
        txtSignupSuccess.check(matches(isDisplayed()))
    }

    fun iVerifyTxtSignUpSuccessShouldBeDisplay() {
        txtSignupSuccess.check(matches(isDisplayed()))
    }

    fun iVerifyBtnLogOutShouldBeDisplay() {
        btnLogOut.check(matches(isDisplayed()))
    }

    fun iClickBtnLogOut() {
        btnLogOut.check(matches(isDisplayed())).perform(click())
    }

}
