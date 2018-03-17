package com.sourcey.materiallogindemo.Test;

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.sourcey.materiallogindemo.MainActivity;
import com.sourcey.materiallogindemo.Page.LoginPage;
import com.sourcey.materiallogindemo.Page.RegisterPage;
import com.sourcey.materiallogindemo.Page.RegisterSuccessPage;
import com.sourcey.materiallogindemo.R;
import com.sourcey.materiallogindemo.Utility.VerifyTextEditUtility;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.withId;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class RegisterTest {

    RegisterPage registerPage = new RegisterPage();
    RegisterSuccessPage registerSuccessPage = new RegisterSuccessPage();
    VerifyTextEditUtility verifyTextEdit = new VerifyTextEditUtility();

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testRegisterAllField_Success_TCRegis0001() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        registerSuccessPage = registerPage.inputRegisterInfoAndSignUpSuccess("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerSuccessPage.verifyRegisterSuccess();
    }

    @Test
    public void testRegisterIgnoreName_Fail_TCRegis002() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        verifyTextEdit.verifyTextErrorMessage(ViewMatchers.withId(R.id.input_name),"at least 3 characters");
    }

    @Test
    public void testRegisterInputNameLessthan3Cheracters_Fail_TCRegis003() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Ji","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_name),"at least 3 characters");
    }

    @Test
    public void testRegisterIgnoreAddress_Fail_TCRegis004() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B","","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_address),"Enter Valid Address");
    }

    @Test
    public void testRegisterIgnoreEmail_Fail_TCRegis005() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","","0800010002","a1234567","a1234567");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_email),"enter a valid email address");
    }

    @Test
    public void testRegisterInvalidEmail_Fail_TCRegis006() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","abc.com","0800010002","a1234567","a1234567");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_email),"enter a valid email address");
    }

    @Test
    public void testRegisterIgnoreMobile_Fail_TCRegis007() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","","a1234567","a1234567");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_mobile),"Enter Valid Mobile Number");
    }

    @Test
    public void testRegisterInputMobileLessThan10_Fail_TCRegis008() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","012345678","a1234567","a1234567");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_mobile),"Enter Valid Mobile Number");
    }

    @Test
    public void testRegisterIgnorePassword_Fail_TCRegis009() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","","a1234567");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_password),"between 4 and 10 alphanumeric characters");
    }

    @Test
    public void testRegisterInputPasswordLessthan4_Fail_TCRegis010() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","abc","a1234567");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_password),"between 4 and 10 alphanumeric characters");
    }

    @Test
    public void testRegisterInputPasswordMorethan10_Fail_TCRegis010() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","abcd1234567","a1234567");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_password),"between 4 and 10 alphanumeric characters");
    }

    @Test
    public void testRegisterIgnoreConfirmPassword_Fail_TCRegis011() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_reEnterPassword),"Password Do not match");
    }

    @Test
    public void testRegisterIgnoreConfirmPassword_Fail_TCRegis012() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","","");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_reEnterPassword),"Password Do not match");
    }


    @Test
    public void testRegisterInputConfirmPasswordLessthan4_Fail_TCRegis013() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a12","a12");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_reEnterPassword),"Password Do not match");
    }

    @Test
    public void testRegisterInputConfirmPasswordMorethan10_Fail_TCRegis014() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a12345678901","a12345678901");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_reEnterPassword),"Password Do not match");
    }

    @Test
    public void testRegisterPasswordNotMatchConfirmPassword_Fail_TCRegis015() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        //registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a1234567");
        registerPage.inputRegisterInfoAndSignUpFail("Jirath B","Test 123 B","jirath.b@gmail.com","0800010002","a1234567","a12345678");
        verifyTextEdit.verifyTextErrorMessage(withId(R.id.input_reEnterPassword),"Password Do not match");
    }

    @Test
    public void testRegisterPressBackButton_Success_TCRegis016() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        registerPage = loginPage.goToRegisterPage();
        Espresso.closeSoftKeyboard();
        Espresso.pressBack();
        loginPage.VerifyObjectOnLoginPage();
    }
}
