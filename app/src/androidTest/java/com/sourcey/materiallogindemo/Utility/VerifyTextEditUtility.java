package com.sourcey.materiallogindemo.Utility;

import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

public class VerifyTextEditUtility {
    public void verifyTextErrorMessage(Matcher<View> matcher, String errorMessage) throws InterruptedException {
        Thread.sleep(1000);
        onView(matcher).perform(click());
        onView(matcher).check(matches(hasErrorText(errorMessage)));
    }
}
