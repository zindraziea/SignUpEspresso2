package com.sourcey.materiallogindemo.Page

import com.sourcey.materiallogindemo.R

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

class RegisterSuccessPage : BasePage() {

    val txtSignupSuccess: ViewInteraction = onView(withText("Hello world!"))
    val btnLogOut: ViewInteraction = onView(withId(R.id.btn_logout))

    @Throws(InterruptedException::class)
    fun verifyRegisterSuccess() {
        isVisible(txtSignupSuccess,3000)
        txtSignupSuccess.check(matches(isDisplayed()))
        btnLogOut.check(matches(isDisplayed()))
    }
}
