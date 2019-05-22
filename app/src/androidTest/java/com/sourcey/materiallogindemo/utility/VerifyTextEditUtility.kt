package com.sourcey.materiallogindemo.utility

import android.view.View

import org.hamcrest.Matcher

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.hasErrorText
import com.sourcey.materiallogindemo.Keyword.screen.BaseScreen

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

class VerifyTextEditUtility : BaseScreen() {
    fun verifyTextErrorMessage(matcher: Matcher<View>, errorMessage: String?) {
        isVisible(onView(matcher))
        onView(matcher).perform(click())
        onView(matcher).check(matches(hasErrorText(errorMessage)))
    }

    fun verifyTextErrorMessage(interaction: ViewInteraction, errorMessage: String?) {
        isVisible(interaction)
        interaction.perform(click())
        interaction.check(matches(hasErrorText(errorMessage)))
    }
}
