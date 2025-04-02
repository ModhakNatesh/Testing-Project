package myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPatientPage {
    public static WebDriver driver;
    
    private By nextbutton = By.id("next-button");
    private By givenNameField = By.name("givenName");
    private By familyNameField = By.name("familyName");
    private By genderDropdown = By.id("gender-field");
    private By birthDayField = By.id("birthdateDay-field");
    private By birthMonthDropdown = By.id("birthdateMonth-field");
    private By birthYearField = By.id("birthdateYear-field");
    private By addressField = By.id("address1");
    private By phoneField = By.name("phoneNumber");
    private By confirmButton = By.id("submit");

    public RegisterPatientPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterGivenName(String givenName) {
        driver.findElement(givenNameField).sendKeys(givenName);
    }

    public void enterFamilyName(String familyName) {
        driver.findElement(familyNameField).sendKeys(familyName);
        driver.findElement(nextbutton).click();
    }

    public void selectGender(String gender) {
        new Select(driver.findElement(genderDropdown)).selectByVisibleText(gender);
    	driver.findElement(nextbutton).click();
    }

    public void enterBirthdate(String day, String month, String year){
        driver.findElement(birthDayField).sendKeys(day);
        new Select(driver.findElement(birthMonthDropdown)).selectByVisibleText(month);
        driver.findElement(birthYearField).sendKeys(year);
    	driver.findElement(nextbutton).click();
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    	driver.findElement(nextbutton).click();
    }

    public void enterPhoneNumber(String phone) throws InterruptedException {
        driver.findElement(phoneField).sendKeys(phone);
    	driver.findElement(nextbutton).click();
    	Thread.sleep(1000);
    	driver.findElement(nextbutton).click();
    }

    public void confirmAndSubmit() {
        driver.findElement(confirmButton).click();
    }
}
