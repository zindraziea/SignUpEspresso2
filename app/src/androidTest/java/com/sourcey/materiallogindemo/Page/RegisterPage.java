package com.sourcey.materiallogindemo.Page;

import android.support.test.espresso.Espresso;

import com.sourcey.materiallogindemo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

public class RegisterPage {
    public RegisterSuccessPage inputRegisterInfoAndSignUpSuccess(String name, String address, String email, String mobile, String password, String confirmPassword) throws InterruptedException {
        inputRegisterInfoAndSignUp(name,address,email,mobile,password,confirmPassword);
        return new RegisterSuccessPage();
    }

    public void inputRegisterInfoAndSignUpFail(String name, String address, String email, String mobile, String password, String confirmPassword) throws InterruptedException {
        inputRegisterInfoAndSignUp(name, address, email, mobile, password, confirmPassword);
    }

    public void inputRegisterInfoAndSignUp(String name, String address, String email, String mobile, String password, String confirmPassword){
        onView(withId(R.id.input_name)).check(matches(isDisplayed())).perform(typeText(name));
        onView(withId(R.id.input_address)).check(matches(isDisplayed())).perform(typeText(address));
        onView(withId(R.id.input_email)).check(matches(isDisplayed())).perform(typeText(email));
        onView(withId(R.id.input_mobile)).check(matches(isDisplayed())).perform(typeText(mobile));
        onView(withId(R.id.input_password)).check(matches(isDisplayed())).perform(typeText(password));
        onView(withId(R.id.input_reEnterPassword)).perform(scrollTo()).check(matches(isDisplayed())).perform(typeText(confirmPassword));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_signup)).check(matches(isDisplayed())).perform(click());
    }


}
