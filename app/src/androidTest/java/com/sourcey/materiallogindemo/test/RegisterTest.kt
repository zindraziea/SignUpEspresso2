package com.sourcey.materiallogindemo.test

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import com.sourcey.materiallogindemo.MainActivity
import com.sourcey.materiallogindemo.Keyword.screen.LoginScreen

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import com.sourcey.materiallogindemo.Keyword.feature.Login
import com.sourcey.materiallogindemo.Keyword.feature.Register


@RunWith(AndroidJUnit4::class)
class RegisterTest {

    private val login by lazy {Login()}
    private val register by lazy {Register()}

    @Rule @JvmField
    val mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testRegisterAllField_Success_TCRegis0001() {
        val loginPage = LoginScreen()
        loginPage.iClickBtnRegister()
        register.inputRegisterInfoAndSignUpSuccess("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "a1234567")
        register.iVerifyRegisterSuccess()
    }

    @Test
    fun testRegisterIgnoreName_Fail_TCRegis002() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "a1234567")
        register.iVerifyNameError("at least 3 characters")
    }

    @Test
    fun testRegisterInputNameLessthan3Cheracters_Fail_TCRegis003() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("Ji", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "a1234567")
        register.iVerifyNameError("at least 3 characters")
    }

    @Test
    fun testRegisterIgnoreAddress_Fail_TCRegis004() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("Jirath B", "", "jirath.b@gmail.com", "0800010002", "a1234567", "a1234567")
        register.iVerifyAddressError("Enter Valid Address")
    }

    @Test
    fun testRegisterIgnoreEmail_Fail_TCRegis005() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "", "0800010002", "a1234567", "a1234567")
        register.iVerifyEmailError("enter a valid email address")
    }

    @Test
    fun testRegisterInvalidEmail_Fail_TCRegis006() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "abc.com", "0800010002", "a1234567", "a1234567")
        register.iVerifyEmailError("enter a valid email address")
    }

    @Test
    fun testRegisterIgnoreMobile_Fail_TCRegis007() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "", "a1234567", "a1234567")
        register.iVerifyMobileError("Enter Valid Mobile Number")
    }

    @Test
    fun testRegisterInputMobileLessThan10_Fail_TCRegis008() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "012345678", "a1234567", "a1234567")
        register.iVerifyMobileError("Enter Valid Mobile Number")
    }

    @Test
    fun testRegisterIgnorePassword_Fail_TCRegis009() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "", "a1234567")
        register.iVerifyPasswordError("between 4 and 10 alphanumeric characters")
    }

    @Test
    fun testRegisterInputPasswordLessthan4_Fail_TCRegis010() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "abc", "a1234567")
        register.iVerifyPasswordError("between 4 and 10 alphanumeric characters")
    }

    @Test
    fun testRegisterInputPasswordMorethan10_Fail_TCRegis010() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "abcd1234567", "a1234567")
        register.iVerifyPasswordError("between 4 and 10 alphanumeric characters")
    }

    @Test
    fun testRegisterIgnoreConfirmPassword_Fail_TCRegis011() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "")
        register.iVerifyReEnterPasswordError("Password Do not match")
    }

    @Test
    fun testRegisterIgnoreConfirmPassword_Fail_TCRegis012() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "", "")
        register.iVerifyReEnterPasswordError("Password Do not match")
    }


    @Test
    fun testRegisterInputConfirmPasswordLessthan4_Fail_TCRegis013() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a12", "a12")
        register.iVerifyReEnterPasswordError("Password Do not match")
    }

    @Test
    fun testRegisterInputConfirmPasswordMorethan10_Fail_TCRegis014() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a12345678901", "a12345678901")
        register.iVerifyReEnterPasswordError("Password Do not match")
    }

    @Test
    fun testRegisterPasswordNotMatchConfirmPassword_Fail_TCRegis015() {
        register.iGotoRegisterScreen()
        register.inputRegisterInfoAndSignUpFail("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "a12345678")
        register.iVerifyReEnterPasswordError("Password Do not match")
    }

    @Test
    fun testRegisterPressBackButton_Success_TCRegis016() {
        register.iGotoRegisterScreen()
        register.iPressBackOnAndroidKeyboard()
        login.VerifyObjectOnLoginPage()
    }
}
