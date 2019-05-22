package com.sourcey.materiallogindemo.Keyword.feature

import android.support.test.espresso.Espresso.pressBack
import com.sourcey.materiallogindemo.Keyword.screen.BaseScreen
import com.sourcey.materiallogindemo.Keyword.screen.LoginScreen
import com.sourcey.materiallogindemo.Keyword.screen.RegisterScreen
import com.sourcey.materiallogindemo.Keyword.screen.RegisterSuccessScreen

class Register  : BaseScreen() {

    private val loginScreen by lazy {LoginScreen()}
    private val registerScreen by lazy {RegisterScreen()}
    private val registerSuccessScreen by lazy {RegisterSuccessScreen()}

    fun inputRegisterInfoAndSignUpSuccess(name: String, address: String, email: String, mobile: String, password: String, confirmPassword: String) {
        inputRegisterInfoAndSignUp(name, address, email, mobile, password, confirmPassword)
    }

    fun inputRegisterInfoAndSignUpFail(name: String, address: String, email: String, mobile: String, password: String, confirmPassword: String) {
        inputRegisterInfoAndSignUp(name, address, email, mobile, password, confirmPassword)
    }

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