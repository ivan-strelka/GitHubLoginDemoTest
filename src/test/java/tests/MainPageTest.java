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
import pages.MainPage;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;


public class MainPageTest {

    public static WebDriver driver;
    public MainPage mainPage;


    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/utils/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().setSize(new Dimension(1200, 800));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://github.com/");
        mainPage = PageFactory.initElements(driver, MainPage.class);

    }

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


    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
