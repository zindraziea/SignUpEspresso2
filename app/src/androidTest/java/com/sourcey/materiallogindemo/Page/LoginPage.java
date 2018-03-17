package com.sourcey.materiallogindemo.Page;

import android.support.test.espresso.Espresso;

import com.sourcey.materiallogindemo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

public class LoginPage extends BasePage{
    public RegisterPage goToRegisterPage(){
        onView(withId(R.id.link_signup)).check(matches(isDisplayed())).perform(click());
        return new RegisterPage();
    }

    public void VerifyObjectOnLoginPage() throws InterruptedException {
        Thread.sleep(1000);
        onView(withText("Email")).check(matches(isDisplayed()));
        onView(withId(R.id.input_email)).check(matches(isDisplayed()));
        onView(withText("Password")).check(matches(isDisplayed()));
        onView(withId(R.id.input_password)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
        onView(withId(R.id.link_signup)).check(matches(isDisplayed()));
    }

    public void inputLoginPageAndLogin(String email,String password) throws InterruptedException {
        Thread.sleep(1000);
        onView(withId(R.id.input_email)).check(matches(isDisplayed())).perform(typeText(email));
        onView(withId(R.id.input_password)).check(matches(isDisplayed())).perform(typeText(password));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click());
    }
}

