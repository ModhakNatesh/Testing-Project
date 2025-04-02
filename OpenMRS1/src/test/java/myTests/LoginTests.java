package myTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import myPages.HomePage;
import myPages.LoginPage;

public class LoginTests {
    static WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void testInvalidCredentials() throws InterruptedException {
    	Thread.sleep(3000);
        loginPage.enterUsername("wrongUser");
        loginPage.enterPassword("wrongPass");
        loginPage.selectInpatientWard();
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed for invalid login.");
    }

    @Test(priority = 2)
    public void testBlankCredentials() throws InterruptedException {
    	Thread.sleep(1000);
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.selectInpatientWard();
        loginPage.clickLogin();
        //Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed for blank login.");
    }

    @Test(priority = 3)
    public void testValidCredentials() throws InterruptedException {
    	Thread.sleep(1000);
        loginPage.enterUsername("admin");
        loginPage.enterPassword("Admin123");
        loginPage.selectInpatientWard();
        loginPage.clickLogin();
    }
    
    @Test(priority = 4)
    public void testRegisterPatientNavigation() throws InterruptedException {
    	Thread.sleep(1000);
        HomePage homePage = new HomePage(driver);
        homePage.clickRegisterPatient();

        Assert.assertTrue(driver.getCurrentUrl().contains("registrationapp"), "Failed to navigate to Register a Patient page.");
    }

//    @AfterClass
//    public void teardown() throws InterruptedException {
//    	Thread.sleep(10000);
//        driver.quit();
//    }
}
