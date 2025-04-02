package myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By inpatientWardOption = By.id("Inpatient Ward");
    private By loginButton = By.id("loginButton");
    private By errorMessage = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void selectInpatientWard() {
        driver.findElement(inpatientWardOption).click();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}
