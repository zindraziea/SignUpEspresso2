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

import com.sourcey.materiallogindemo.Keyword.feature.Login


@RunWith(AndroidJUnit4::class)
class LoginTest {

    private val login by lazy {Login()}

    @Rule @JvmField
    val mActivityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    @Throws(InterruptedException::class)
    fun testLoginIgnoreEmailPassword_Fail_TCLogin0001() {
        login.inputLoginPageAndLogin("", "")
        login.iVerifyErrorMessage("enter a valid email address","between 4 and 10 alphanumeric characters")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testLoginInvalidEmail_Fail_TCLogin0002() {
        login.inputLoginPageAndLogin("test1@a", "a1234")
        login.iVerifyErrorMessage("enter a valid email address",null)
    }

    @Test
    @Throws(InterruptedException::class)
    fun testLoginIgnorePassword_Fail_TCLogin0003() {
        login.inputLoginPageAndLogin("test1@a.com", "")
        login.iVerifyErrorMessage(null,"between 4 and 10 alphanumeric characters")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testLoginInputPasswordLessThan4_Fail_TCLogin0004() {
        login.inputLoginPageAndLogin("test1@a.com", "a12")
        login.iVerifyErrorMessage(null,"between 4 and 10 alphanumeric characters")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testLoginInputPasswordMoreThan10_Fail_TCLogin0005() {
        login.inputLoginPageAndLogin("test1@a.com", "a1234567890")
        login.iVerifyErrorMessage(null,"between 4 and 10 alphanumeric characters")
    }

    @Test
    @Throws(InterruptedException::class)
    fun testLoginInvalidEmailPassword_Fail_TCLogin0001() {
        login.inputLoginPageAndLogin("test1@a.com", "a1234567")
        login.iVerifyErrorMessage(null,"enter a valid email address or password")
    }
}

