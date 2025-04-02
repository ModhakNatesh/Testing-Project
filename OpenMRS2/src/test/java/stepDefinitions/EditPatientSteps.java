package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import myPages.EditPatientPage;
import myPages.LoginPage;

public class EditPatientSteps {
    WebDriver driver;
    EditPatientPage editPage;

    @Given("the user logs into OpenMRS")
    public void userLogsIn() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://o2.openmrs.org/openmrs/login.htm");

        // Perform login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("admin");
        loginPage.enterPassword("Admin123");
        loginPage.selectLocation();
        loginPage.clickLogin();

        editPage = new EditPatientPage(driver);
    }

    @Given("they navigate to Find Patient Record")
    public void navigateToFindPatientRecord() {
        editPage.navigateToFindPatientRecord();
    }

    @When("they select a patient record")
    public void selectPatientRecord() {
        editPage.selectPatientRecord();
    }

    @When("they click on Edit Registration Information")
    public void clickEditRegistration() {
        editPage.clickEditRegistration();
    }

    @When("they update the family name to {string}")
    public void updateFamilyName(String newName) {
        editPage.updateFamilyName(newName);
    }

    @When("they navigate through demographic steps")
    public void navigateThroughDemographics() {
        editPage.clickNextButton();
        editPage.clickNextButton();
        editPage.clickNextButton();
        editPage.clickConfirmButton();
    }

    @Then("the patient details should be updated successfully")
    public void validateUpdatedDetails() throws InterruptedException {
    	Thread.sleep(10000);
        Assert.assertTrue(editPage.isUpdated(), "Family name update failed.");
        driver.quit();
    }
}
