package com.sourcey.materiallogindemo.keywords.features

import com.sourcey.materiallogindemo.keywords.screens.LoginScreen

object Login {

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