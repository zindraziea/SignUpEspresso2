package com.sourcey.materiallogindemo.Test;

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.sourcey.materiallogindemo.MainActivity;
import com.sourcey.materiallogindemo.Page.LoginPage;
import com.sourcey.materiallogindemo.R;
import com.sourcey.materiallogindemo.Utility.VerifyTextEditUtility;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.withId;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginTest {

    VerifyTextEditUtility verifyTextEdit = new VerifyTextEditUtility();

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testLoginIgnoreEmailPassword_Fail_TCLogin0001() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLoginPageAndLogin("","");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_email),"enter a valid email address");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_password),"between 4 and 10 alphanumeric characters");
    }

    @Test
    public void testLoginInvalidEmail_Fail_TCLogin0002() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLoginPageAndLogin("test1@a","a1234");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_email),"enter a valid email address");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_password),null);
    }

    @Test
    public void testLoginIgnorePassword_Fail_TCLogin0003() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLoginPageAndLogin("test1@a.com","");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_email),null);
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_password),"between 4 and 10 alphanumeric characters");
    }

    @Test
    public void testLoginInputPasswordLessThan4_Fail_TCLogin0004() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLoginPageAndLogin("test1@a.com","a12");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_email),null);
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_password),"between 4 and 10 alphanumeric characters");
    }

    @Test
    public void testLoginInputPasswordMoreThan10_Fail_TCLogin0005() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLoginPageAndLogin("test1@a.com","a1234567890");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_email),null);
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_password),"between 4 and 10 alphanumeric characters");
    }

    @Test
    public void testLoginInvalidEmailPassword_Fail_TCLogin0001() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.inputLoginPageAndLogin("test1@a.com","a1234567");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_email),null);
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_password),"enter a valid email address or password");
    }
}

