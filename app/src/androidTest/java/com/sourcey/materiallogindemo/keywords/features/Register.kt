package com.sourcey.materiallogindemo.keywords.features

import android.support.test.espresso.Espresso.pressBack
import com.sourcey.materiallogindemo.keywords.screens.LoginScreen
import com.sourcey.materiallogindemo.keywords.screens.RegisterScreen
import com.sourcey.materiallogindemo.keywords.screens.RegisterSuccessScreen

object Register {

    private val loginScreen by lazy {LoginScreen()}
    private val registerScreen by lazy {RegisterScreen()}
    private val registerSuccessScreen by lazy {RegisterSuccessScreen()}

    fun inputRegisterInfoAndSignUp(name: String, address: String, email: String, mobile: String, password: String, confirmPassword: String) {
        registerScreen.iInputName(name)
        registerScreen.iInputAddress(address)
        registerScreen.iInputEmail(email)
        registerScreen.iInputMobile(mobile)
        registerScreen.iInputPassword(password)
        registerScreen.iInputReEnterPassword(confirmPassword)
        registerScreen.iClickBtnSignUp()
    }

    fun iGotoRegisterScreen() {
        loginScreen.iClickBtnRegister()
    }

    fun iPressBackOnAndroidKeyboard() {
        pressBack()
    }

    fun iVerifyRegisterSuccess() {
        registerSuccessScreen.iCanSeeSignUpSuccessScreen()
        registerSuccessScreen.iVerifyTxtSignUpSuccessShouldBeDisplay()
        registerSuccessScreen.iVerifyBtnLogOutShouldBeDisplay()
        registerSuccessScreen.iClickBtnLogOut()
    }

    fun iVerifyNameError(errorMessage: String?) {
        registerScreen.iVerifyNameError(errorMessage)
    }

    fun iVerifyAddressError(errorMessage: String?) {
        registerScreen.iVerifyAddress(errorMessage)
    }

    fun iVerifyEmailError(errorMessage: String?) {
        registerScreen.iVerifyEmail(errorMessage)
    }

    fun iVerifyMobileError(errorMessage: String?) {
        registerScreen.iVerifyMobile(errorMessage)
    }

    fun iVerifyPasswordError(errorMessage: String?) {
        registerScreen.iVerifyPassword(errorMessage)
    }

    fun iVerifyReEnterPasswordError(errorMessage: String?) {
        registerScreen.iVerifyReEnterPassword(errorMessage)
    }
}