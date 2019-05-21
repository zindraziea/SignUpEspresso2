package com.sourcey.materiallogindemo.Utility

import android.view.View

import org.hamcrest.Matcher

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.hasErrorText

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

class VerifyTextEditUtility {
    @Throws(InterruptedException::class)
    fun verifyTextErrorMessage(matcher: Matcher<View>, errorMessage: String?) {
        Thread.sleep(1000)
        onView(matcher).perform(click())
        onView(matcher).check(matches(hasErrorText(errorMessage)))
    }
}
