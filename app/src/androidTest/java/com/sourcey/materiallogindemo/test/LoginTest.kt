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


@RunWith(AndroidJUnit4::class)
class LoginTest {

    @Rule @JvmField
    val mActivityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testLoginIgnoreEmailPassword_Fail_TCLogin0001() {
        Login.inputLoginPageAndLogin("", "")
        Login.iVerifyErrorMessage("enter a valid email address","between 4 and 10 alphanumeric characters")
    }

    @Test
    fun testLoginInvalidEmail_Fail_TCLogin0002() {
        Login.inputLoginPageAndLogin("test1@a", "a1234")
        Login.iVerifyErrorMessage("enter a valid email address",null)
    }

    @Test
    fun testLoginIgnorePassword_Fail_TCLogin0003() {
        Login.inputLoginPageAndLogin("test1@a.com", "")
        Login.iVerifyErrorMessage(null,"between 4 and 10 alphanumeric characters")
    }

    @Test
    fun testLoginInputPasswordLessThan4_Fail_TCLogin0004() {
        Login.inputLoginPageAndLogin("test1@a.com", "a12")
        Login.iVerifyErrorMessage(null,"between 4 and 10 alphanumeric characters")
    }

    @Test
    fun testLoginInputPasswordMoreThan10_Fail_TCLogin0005() {
        Login.inputLoginPageAndLogin("test1@a.com", "a1234567890")
        Login.iVerifyErrorMessage(null,"between 4 and 10 alphanumeric characters")
    }

    @Test
    fun testLoginInvalidEmailPassword_Fail_TCLogin0001() {
        Login.inputLoginPageAndLogin("test1@a.com", "a1234567")
        Login.iVerifyErrorMessage(null,"enter a valid email address or password")
    }
}

