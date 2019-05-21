package com.sourcey.materiallogindemo.Test

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

import android.support.test.espresso.Espresso
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest

import com.sourcey.materiallogindemo.MainActivity
import com.sourcey.materiallogindemo.Page.LoginPage
import com.sourcey.materiallogindemo.Page.RegisterPage
import com.sourcey.materiallogindemo.Page.RegisterSuccessPage
import com.sourcey.materiallogindemo.R
import com.sourcey.materiallogindemo.Utility.VerifyTextEditUtility

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import android.support.test.espresso.matcher.ViewMatchers.withId


@LargeTest
@RunWith(AndroidJUnit4::class)
class RegisterTest {

    internal var registerPage = RegisterPage()
    internal var registerSuccessPage = RegisterSuccessPage()
    internal var verifyTextEdit = VerifyTextEditUtility()

    @Rule @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterAllField_Success_TCRegis0001() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        registerPage.inputRegisterInfoAndSignUpSuccess("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "a1234567")
        registerSuccessPage.verifyRegisterSuccess()
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterIgnoreName_Fail_TCRegis002() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "a1234567")
        verifyTextEdit.verifyTextErrorMessage(ViewMatchers.withId(R.id.input_name), "at least 3 characters")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterInputNameLessthan3Cheracters_Fail_TCRegis003() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Ji", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "a1234567")
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_name), "at least 3 characters")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterIgnoreAddress_Fail_TCRegis004() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B", "", "jirath.b@gmail.com", "0800010002", "a1234567", "a1234567")
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_address), "Enter Valid Address")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterIgnoreEmail_Fail_TCRegis005() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "", "0800010002", "a1234567", "a1234567")
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_email), "enter a valid email address")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterInvalidEmail_Fail_TCRegis006() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "abc.com", "0800010002", "a1234567", "a1234567")
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_email), "enter a valid email address")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterIgnoreMobile_Fail_TCRegis007() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "", "a1234567", "a1234567")
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_mobile), "Enter Valid Mobile Number")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterInputMobileLessThan10_Fail_TCRegis008() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "012345678", "a1234567", "a1234567")
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_mobile), "Enter Valid Mobile Number")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterIgnorePassword_Fail_TCRegis009() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "", "a1234567")
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_password), "between 4 and 10 alphanumeric characters")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterInputPasswordLessthan4_Fail_TCRegis010() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "abc", "a1234567")
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_password), "between 4 and 10 alphanumeric characters")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterInputPasswordMorethan10_Fail_TCRegis010() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "abcd1234567", "a1234567")
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_password), "between 4 and 10 alphanumeric characters")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterIgnoreConfirmPassword_Fail_TCRegis011() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "")
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_reEnterPassword), "Password Do not match")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterIgnoreConfirmPassword_Fail_TCRegis012() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "", "")
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_reEnterPassword), "Password Do not match")
    }


    @Test
    @Throws(InterruptedException::class)
    fun testRegisterInputConfirmPasswordLessthan4_Fail_TCRegis013() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a12", "a12")
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_reEnterPassword), "Password Do not match")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterInputConfirmPasswordMorethan10_Fail_TCRegis014() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a12345678901", "a12345678901")
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_reEnterPassword), "Password Do not match")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterPasswordNotMatchConfirmPassword_Fail_TCRegis015() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "a12345678")
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_reEnterPassword), "Password Do not match")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRegisterPressBackButton_Success_TCRegis016() {
        val loginPage = LoginPage()
        loginPage.goToRegisterPage()
        Espresso.closeSoftKeyboard()
        Espresso.pressBack()
        loginPage.VerifyObjectOnLoginPage()
    }
}
