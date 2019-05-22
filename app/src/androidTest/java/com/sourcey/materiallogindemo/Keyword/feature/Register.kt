package com.sourcey.materiallogindemo.Keyword.feature

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.pressBack
import com.sourcey.materiallogindemo.Keyword.screen.BaseScreen
import com.sourcey.materiallogindemo.Keyword.screen.LoginScreen
import com.sourcey.materiallogindemo.Keyword.screen.RegisterScreen

class Register  : BaseScreen() {

    internal var loginScreen = LoginScreen()
    internal var registerScreen = RegisterScreen()

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
}