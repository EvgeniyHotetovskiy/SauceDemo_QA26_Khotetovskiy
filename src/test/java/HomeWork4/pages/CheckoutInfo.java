package HomeWork4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfo extends BasePage {
    private final static By CHECKOUT_YOUR_INFORMATION = By.cssSelector("span[class=title]");
    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By ZIP_CODE = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");
    public CheckoutInfo(WebDriver driver) {
        super(driver);
    }
    public String getCheckoutInfo () {
        return driver.findElement(CHECKOUT_YOUR_INFORMATION).getText();
    }
    public void setFirstNameValue(String firstNameValue) {
        driver.findElement(FIRST_NAME).sendKeys(firstNameValue);
    }
    public void setLastNameValue(String lastNameValue) {
        driver.findElement(LAST_NAME).sendKeys(lastNameValue);
    }
    public void setZipCodeValue(String zipCodeValue) {
        driver.findElement(ZIP_CODE).sendKeys(zipCodeValue);
    }
    public void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }
    public void setYourInformation(String firstNameValue, String lastNameValue, String zipCodeValue) {
        setFirstNameValue(firstNameValue);
        setLastNameValue(lastNameValue);
        setZipCodeValue(zipCodeValue);
        clickContinueButton();
    }

}
