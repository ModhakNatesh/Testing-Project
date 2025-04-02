package myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPatientPage {
    WebDriver driver;

    // Locators
    By findPatientRecord = By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension");
    By selectedPatient = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[2]");
    By editRegistration = By.xpath("/html/body/div[1]/div[3]/div[9]/div[2]/div/ul/li[7]/a/div/div[2]");
    By familyNameField = By.name("familyName");
    By nextButton = By.id("next-button");
    By confirmButton = By.id("registration-submit");    
    By updatedText = By.xpath("/html/body/div[1]/div[3]/div[9]/div[1]/div/div[1]/div[1]/div[2]/div[3]/p");

    public EditPatientPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToFindPatientRecord() {
        driver.findElement(findPatientRecord).click();
    }

    public void selectPatientRecord() {
        driver.findElement(selectedPatient).click();
    }

    public void clickEditRegistration() {
        driver.findElement(editRegistration).click();
    }

    public void updateFamilyName(String newName) {
    	driver.findElement(By.id("demographics-edit-link")).click();
        WebElement familyName = driver.findElement(familyNameField);
        familyName.clear();
        familyName.sendKeys(newName);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public boolean isUpdated() {
        return driver.findElement(updatedText).getText().equals("Smith");
    }
}
