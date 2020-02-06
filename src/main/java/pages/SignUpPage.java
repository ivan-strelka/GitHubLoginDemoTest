package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    public WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }


    private By heading = By.xpath("//h1[text()='Create your account']");
    private By userNameField = By.xpath("//input[@id='user_login']");
    private By userEmailField = By.xpath("//input[@id='user_email']");
    private By passwordField = By.xpath("//input[@id='user_password']");
    private By submitButton = By.xpath("//button[@id='signup_button']");
    private By userNameError = By.xpath("//div[contains(@class,'mb-1')]");
    private By headingJoinGitHub = By.xpath("//div[text()='Join GitHub']");
    private By headingCreateAccount = By.xpath("//h1[text()='Create your account']");


    public SignUpPage typeUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typeUserEmail(String email) {
        driver.findElement(userEmailField).sendKeys(email);
        return this;
    }

    public SignUpPage typeUserPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }


    public String getHeadingCreateAccountText() {
        return driver.findElement(headingCreateAccount).getText();
    }

    public String getHeadingJoinGitHubText() {
        return driver.findElement(headingJoinGitHub).getText();
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getUserNameErrorText() {
        return driver.findElement(userNameError).getText();
    }


    public SignUpPage registerWithInvalidCreds(String username, String useremail, String password) {
        this.typeUserName(username);
        this.typeUserEmail(useremail);
        this.typeUserPassword(password);
        driver.findElement(submitButton).click();
        return new SignUpPage(driver);
    }


}
