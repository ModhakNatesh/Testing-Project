package myTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import myPages.HomePage;
import myPages.RegisterPatientPage;

public class RegisterPatientTests {
    public static WebDriver driver;
    HomePage homePage;
    RegisterPatientPage registerPatientPage;

    @BeforeClass
    public void setup() {
        driver = LoginTests.driver; 
        homePage = new HomePage(driver);
        registerPatientPage = new RegisterPatientPage(driver);
    }

    @Test(priority = 1)
    public void testRegisterPatient() throws InterruptedException {
    	Thread.sleep(3000);
        registerPatientPage.enterGivenName("NewMan");
        registerPatientPage.enterFamilyName("Patient");
        registerPatientPage.selectGender("Female");
        registerPatientPage.enterBirthdate("11", "March", "1995");
        registerPatientPage.enterAddress("124 Main Street");
        registerPatientPage.enterPhoneNumber("7879943210");
        registerPatientPage.confirmAndSubmit();
        Thread.sleep(10000);
        Assert.assertTrue(driver.getCurrentUrl().contains("patientId"), "Patient registration failed.");
    }
}
