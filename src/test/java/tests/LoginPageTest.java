package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.SignUpPage;
import utils.WedDriverSettings.WebDiverSettings;

import java.util.concurrent.TimeUnit;

public class LoginPageTest extends WebDiverSettings {

    public static WebDriver driver;
    public LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/utils/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().setSize(new Dimension(1200, 800));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://github.com/login");
        loginPage = PageFactory.initElements(driver, LoginPage.class);

    }

    @Test
    public void loginWithEmptyCred() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("", "");
        String error = newLoginPage.getErrorText();
        Assertions.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithEInvalidCred() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("2qqfds12", "12312edewd");
        String error = newLoginPage.getErrorText();
        Assertions.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void createAccTest() {
        SignUpPage signUpPage = loginPage.createAccount();
        String hiddingText = signUpPage.getHeadingText();
        Assertions.assertEquals("Create your account", hiddingText);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
