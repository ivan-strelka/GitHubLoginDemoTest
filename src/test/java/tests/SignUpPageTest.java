package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    public static WebDriver driver;
    public SignUpPage signUpPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/utils/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().setSize(new Dimension(1200, 800));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://github.com/join");
        signUpPage = PageFactory.initElements(driver, SignUpPage.class);

    }


    @Test
    void signUpWithShortName() {
        SignUpPage sp = signUpPage.typeUserName("ds123");
        String error = signUpPage.getUserNameErrorText();
        Assertions.assertEquals("Username ds123 is not available.", error);
    }

    @Test
    void signUpWithBusyName() {
        SignUpPage sp = signUpPage.typeUserName("username");
        String error = signUpPage.getUserNameErrorText();
        Assertions.assertEquals("Username 'username' is unavailable.", error);
    }

    @Test
    void haveHeadingText() {
        String text = signUpPage.getHeadingText();
        Assertions.assertEquals("Create your account", text);
    }

    @Test
    void haveHeadingText2() {
        String text = signUpPage.getHeadingJoinGitHubText();
        Assertions.assertEquals("Join GitHub", text);
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
