package com.sourcey.materiallogindemo.Page;

import com.sourcey.materiallogindemo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

public class RegisterSuccessPage {
    public void verifyRegisterSuccess() throws InterruptedException {
        Thread.sleep(3000);
        onView(withText("Hello world!")).check(matches(isDisplayed()));
        onView(withId(R.id.btn_logout)).check(matches(isDisplayed()));
    }
}
