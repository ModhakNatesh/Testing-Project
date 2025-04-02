package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import myPages.LoginPage;
import org.testng.Assert;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("the user is on the OpenMRS login page")
    public void openLoginPage() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        loginPage = new LoginPage(driver);
    }

    @When("they enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("they select the location and click login")
    public void selectLocationAndLogin() {
        loginPage.selectLocation();
        loginPage.clickLogin();
    }

    @Then("they should see an error message")
    public void verifyErrorMessage() {
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed for invalid login.");
        driver.quit();
    }

    @Then("they should be redirected to the home page")
    public void verifySuccessfulLogin() {
        Assert.assertTrue(driver.getCurrentUrl().contains("home"), "User should be on the home page.");
        driver.quit();
    }
}
