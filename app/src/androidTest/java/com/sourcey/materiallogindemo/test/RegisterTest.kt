package com.sourcey.materiallogindemo.test

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import com.sourcey.materiallogindemo.MainActivity

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import com.sourcey.materiallogindemo.keywords.features.Login
import com.sourcey.materiallogindemo.keywords.features.Register


@RunWith(AndroidJUnit4::class)
class RegisterTest {

    @Rule @JvmField
    val mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testRegisterAllField_Success_TCRegis0001() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "a1234567")
        Register.iVerifyRegisterSuccess()
    }

    @Test
    fun testRegisterIgnoreName_Fail_TCRegis002() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "a1234567")
        Register.iVerifyNameError("at least 3 characters")
    }

    @Test
    fun testRegisterInputNameLessthan3Cheracters_Fail_TCRegis003() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Ji", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "a1234567")
        Register.iVerifyNameError("at least 3 characters")
    }

    @Test
    fun testRegisterIgnoreAddress_Fail_TCRegis004() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Jirath B", "", "jirath.b@gmail.com", "0800010002", "a1234567", "a1234567")
        Register.iVerifyAddressError("Enter Valid Address")
    }

    @Test
    fun testRegisterIgnoreEmail_Fail_TCRegis005() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Jirath B", "Test 123 B", "", "0800010002", "a1234567", "a1234567")
        Register.iVerifyEmailError("enter a valid email address")
    }

    @Test
    fun testRegisterInvalidEmail_Fail_TCRegis006() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Jirath B", "Test 123 B", "abc.com", "0800010002", "a1234567", "a1234567")
        Register.iVerifyEmailError("enter a valid email address")
    }

    @Test
    fun testRegisterIgnoreMobile_Fail_TCRegis007() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Jirath B", "Test 123 B", "jirath.b@gmail.com", "", "a1234567", "a1234567")
        Register.iVerifyMobileError("Enter Valid Mobile Number")
    }

    @Test
    fun testRegisterInputMobileLessThan10_Fail_TCRegis008() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Jirath B", "Test 123 B", "jirath.b@gmail.com", "012345678", "a1234567", "a1234567")
        Register.iVerifyMobileError("Enter Valid Mobile Number")
    }

    @Test
    fun testRegisterIgnorePassword_Fail_TCRegis009() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "", "a1234567")
        Register.iVerifyPasswordError("between 4 and 10 alphanumeric characters")
    }

    @Test
    fun testRegisterInputPasswordLessthan4_Fail_TCRegis010() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "abc", "a1234567")
        Register.iVerifyPasswordError("between 4 and 10 alphanumeric characters")
    }

    @Test
    fun testRegisterInputPasswordMorethan10_Fail_TCRegis010() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "abcd1234567", "a1234567")
        Register.iVerifyPasswordError("between 4 and 10 alphanumeric characters")
    }

    @Test
    fun testRegisterIgnoreConfirmPassword_Fail_TCRegis011() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "")
        Register.iVerifyReEnterPasswordError("Password Do not match")
    }

    @Test
    fun testRegisterIgnoreConfirmPassword_Fail_TCRegis012() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "", "")
        Register.iVerifyReEnterPasswordError("Password Do not match")
    }


    @Test
    fun testRegisterInputConfirmPasswordLessthan4_Fail_TCRegis013() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a12", "a12")
        Register.iVerifyReEnterPasswordError("Password Do not match")
    }

    @Test
    fun testRegisterInputConfirmPasswordMorethan10_Fail_TCRegis014() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a12345678901", "a12345678901")
        Register.iVerifyReEnterPasswordError("Password Do not match")
    }

    @Test
    fun testRegisterPasswordNotMatchConfirmPassword_Fail_TCRegis015() {
        Register.iGotoRegisterScreen()
        Register.inputRegisterInfoAndSignUp("Jirath B", "Test 123 B", "jirath.b@gmail.com", "0800010002", "a1234567", "a12345678")
        Register.iVerifyReEnterPasswordError("Password Do not match")
    }

    @Test
    fun testRegisterPressBackButton_Success_TCRegis016() {
        Register.iGotoRegisterScreen()
        Register.iPressBackOnAndroidKeyboard()
        Login.VerifyObjectOnLoginPage()
    }
}
