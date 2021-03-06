package utils.WedDriverSettings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

import java.util.concurrent.TimeUnit;


public class WebDiverSettings {

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


    @AfterEach
    public void tearDown() {
        driver.quit();
    }


}
