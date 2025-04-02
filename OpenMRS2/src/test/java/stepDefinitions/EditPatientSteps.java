package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import myPages.PatientDetailsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EditPatientSteps {
    WebDriver driver;
    PatientDetailsPage patientDetailsPage;

    @Given("the user is on the patient details page")
    public void navigateToPatientDetails() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://o2.openmrs.org/openmrs/coreapps/clinicianfacing/patient.page?patientId=fab8a1d6-b3f1-4f6e-b6b2-526fcd5f094e");
        patientDetailsPage = new PatientDetailsPage(driver);
    }

    @When("they click on Edit Registration Information")
    public void clickEditRegistration() {
        patientDetailsPage.clickEditRegistration();
    }

    @When("they update the family name to {string}")
    public void updateFamilyName(String newName) {
        patientDetailsPage.updateFamilyName(newName);
    }

    @When("they navigate through demographic steps")
    public void navigateThroughDemographics() {
        patientDetailsPage.clickNextButton(); // 3 times
        patientDetailsPage.clickNextButton();
        patientDetailsPage.clickNextButton();
        patientDetailsPage.clickConfirmButton();
    }

    @Then("the patient details should be updated successfully")
    public void validateUpdatedDetails() {
        Assert.assertTrue(patientDetailsPage.isUpdated(), "Family name update failed.");
        driver.quit();
    }
}
