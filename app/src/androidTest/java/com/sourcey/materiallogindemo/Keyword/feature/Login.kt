package com.sourcey.materiallogindemo.Keyword.feature

import android.support.test.espresso.Espresso.closeSoftKeyboard
import com.sourcey.materiallogindemo.Keyword.screen.BaseScreen
import com.sourcey.materiallogindemo.Keyword.screen.LoginScreen

class Login : BaseScreen() {

    internal var loginScreen = LoginScreen()

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
}