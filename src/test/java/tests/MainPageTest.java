package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import utils.WedDriverSettings.WebDiverSettings;


public class MainPageTest extends WebDiverSettings {

    @Test
    public void register() {
        MainPage mainPage = new MainPage(driver);
        mainPage.register("sdfsdf", "dsfsdfsdfsd@dsfds.com", "123wersfSA@!@");
    }
}
