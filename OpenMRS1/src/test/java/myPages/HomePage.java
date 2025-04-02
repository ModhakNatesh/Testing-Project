package myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    private By registerPatientButton = By.xpath("//a[contains(@href, 'registerPatient')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegisterPatient() {
        driver.findElement(registerPatientButton).click();
    }
}
