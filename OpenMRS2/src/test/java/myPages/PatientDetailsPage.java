package myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientDetailsPage {
    WebDriver driver;

    public PatientDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEditRegistration() {
        driver.findElement(By.xpath("//a[contains(text(),'Edit Registration Information')]")).click();
    }

    public void updateFamilyName(String newName) {
        WebElement familyNameField = driver.findElement(By.name("personName.familyName"));
        familyNameField.clear();
        familyNameField.sendKeys(newName);
    }

    public void clickNextButton() {
        driver.findElement(By.id("next-button")).click();
    }

    public void clickConfirmButton() {
        driver.findElement(By.id("confirm-button")).click();
    }

    public boolean isUpdated() {
        return driver.getPageSource().contains("Updated successfully");
    }
}
