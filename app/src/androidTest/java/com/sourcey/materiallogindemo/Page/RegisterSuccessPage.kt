package com.sourcey.materiallogindemo.Page

import com.sourcey.materiallogindemo.R

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

class RegisterSuccessPage {
    @Throws(InterruptedException::class)
    fun verifyRegisterSuccess() {
        Thread.sleep(3000)
        onView(withText("Hello world!")).check(matches(isDisplayed()))
        onView(withId(R.id.btn_logout)).check(matches(isDisplayed()))
    }
}
