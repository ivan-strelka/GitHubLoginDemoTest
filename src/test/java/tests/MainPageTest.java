package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SignUpPage;
import utils.WedDriverSettings.WebDiverSettings;


public class MainPageTest extends WebDiverSettings {

    @Test
    void signInTest() {
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHidingText();
        Assertions.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    void registerFailTest() {
        SignUpPage signUpPage = mainPage.register("sdfrr", "sdfsdfdsfds.com", "ff1!!ffsASD23");
        String error = signUpPage.getUserNameErrorText();
        Assertions.assertEquals("There were problems creating your account.", error);
    }

    @Test
    void signUpWithEmptyUserFields() {
        SignUpPage signUpPage = mainPage.register("", "fsdfds", "fds!Fqwe!87");
        String error = signUpPage.getUserNameErrorText();
        Assertions.assertEquals("There were problems creating your account.", error);

    }

    @Test
    void signUpWithEmptyUserAndEmailFields() {
        SignUpPage signUpPage = mainPage.register("", "", "fds!Fqwe!87");
        String error = signUpPage.getUserNameErrorText();
        Assertions.assertEquals("There were problems creating your account.", error);
    }

    @Test
    void signUpWithEmptyAllFields() {
        SignUpPage signUpPage = mainPage.register("", "", "");
        String error = signUpPage.getUserNameErrorText();
        Assertions.assertEquals("There were problems creating your account.", error);
    }


}
