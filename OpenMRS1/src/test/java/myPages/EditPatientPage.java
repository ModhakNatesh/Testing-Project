package myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditPatientPage {
    WebDriver driver;

    private By editinfo = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[9]/div[2]/div[1]/ul[1]/li[7]/a[1]/div[1]/div[2]");
    private By editRegistrationInfoButton = By.id("demographics-edit-link"); 
    private By familyNameField = By.name("familyName"); 
    private By nextButton = By.id("next-button");
    private By confirmButton = By.id("registration-submit");

    public EditPatientPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEditRegistrationInfo() throws InterruptedException {
    	driver.findElement(editinfo).click();
    	Thread.sleep(3000);
        driver.findElement(editRegistrationInfoButton).click();
    }

    public void updateFamilyName(String newFamilyName) {
        driver.findElement(familyNameField).clear();
        driver.findElement(familyNameField).sendKeys(newFamilyName);
    }

    public void clickNextMultipleTimes(int times) {
        for (int i = 0; i < times; i++) {
            driver.findElement(nextButton).click();
        }
    }

    public void clickConfirm() {
        driver.findElement(confirmButton).click();
    }
}
