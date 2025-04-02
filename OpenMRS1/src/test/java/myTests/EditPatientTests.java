package myTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import myPages.EditPatientPage;

public class EditPatientTests {
    WebDriver driver;
    EditPatientPage editPatientPage;

    @BeforeClass
    public void setup() {
        driver = LoginTests.driver; 
        editPatientPage = new EditPatientPage(driver);
    }

    @Test(priority = 1)
    public void testEditPatientInformation() throws InterruptedException {
        editPatientPage.clickEditRegistrationInfo();
        editPatientPage.updateFamilyName("Smith");
        editPatientPage.clickNextMultipleTimes(3);
        editPatientPage.clickConfirm();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("patientId"), "Patient update failed.");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul/li[3]/a")).click();
    }
}
