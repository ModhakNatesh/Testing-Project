package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import myPages.HomePage;
import myPages.LoginPage;
import myPages.RegisterPatientPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegisterPatientSteps {
    WebDriver driver;
    HomePage homePage;
    RegisterPatientPage registerPatientPage;

    @Given("the user is logged into OpenMRS")
    public void userIsLoggedIn() {
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

        homePage = new HomePage(driver);
    }


    @When("they navigate to the Register Patient page")
    public void navigateToRegisterPatient() {
        homePage.clickRegisterPatient();
        registerPatientPage = new RegisterPatientPage(driver);
    }

    @When("they enter {string} as the given name and {string} as the family name")
    public void enterPatientName(String givenName, String familyName) {
        registerPatientPage.enterGivenName(givenName);
        registerPatientPage.enterFamilyName(familyName);
    }

    @When("they select {string} as gender and enter birthdate {string}")
    public void enterGenderAndBirthdate(String gender, String birthdate) {
        String[] dateParts = birthdate.split(" ");
        registerPatientPage.selectGender(gender);
        registerPatientPage.enterBirthdate(dateParts[0], dateParts[1], dateParts[2]);
    }

    @When("they provide address {string} and phone number {string}")
    public void enterAddressAndPhone(String address, String phone) throws InterruptedException {
        registerPatientPage.enterAddress(address);
        registerPatientPage.enterPhoneNumber(phone);
    }

    @When("they submit the registration form")
    public void submitRegistrationForm() {
        registerPatientPage.confirmAndSubmit();
    }

    @Then("the patient should be successfully registered")
    public void validateSuccessfulRegistration() throws InterruptedException {
    	Thread.sleep(5000);
        Assert.assertTrue(driver.getCurrentUrl().contains("patientId"), "Patient registration failed.");
    }
}
