package com.sourcey.materiallogindemo.Keyword.feature

import com.sourcey.materiallogindemo.Keyword.screen.BaseScreen
import com.sourcey.materiallogindemo.Keyword.screen.LoginScreen

class Login : BaseScreen() {

    private val loginScreen by lazy {LoginScreen()}

    fun VerifyObjectOnLoginPage() {
        loginScreen.iCanSeeLoginScreen()
        loginScreen.iVerifyTxtEmailShouldbeDisplayed()
        loginScreen.iVerifyTxtInputEmailShouldbeDisplayed()
        loginScreen.iVerifyTxtPasswordShouldbeDisplayed()
        loginScreen.iVerifyTxtInputPasswordShouldbeDisplayed()
        loginScreen.iVerifyBtnLoginShouldbeDisplayed()
        loginScreen.iVerifyBtnSignUpShouldbeDisplayed()
    }

    fun inputLoginPageAndLogin(email: String, password: String) {
        loginScreen.iCanSeeLoginScreen()
        loginScreen.iInputEmail(email)
        loginScreen.iInputPassword(password)
        loginScreen.iClickBtnLogin()
    }

    fun iVerifyErrorMessage(loginError: String?, passwordError: String?) {
        loginScreen.iVerifyLoginError(loginError)
        loginScreen.iVerifyPasswordError(passwordError)
    }
}