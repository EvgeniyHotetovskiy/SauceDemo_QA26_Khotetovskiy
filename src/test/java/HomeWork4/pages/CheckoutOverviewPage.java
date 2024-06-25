package HomeWork4.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage{
    private final static By CHECKOUT_OVERVIEW = By.cssSelector("span[class=title]");
    private final static By TOTAL_PRICE = By.className("summary_total_label");
    private final static By FINISH_BUTTON = By.id("finish");
    private final static By CHECKOUT_COMPLETE = By.cssSelector("span[class=title]");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка текста заглавия")
    public String getPageTitle() {
        return driver.findElement(CHECKOUT_OVERVIEW).getText();
    }

    @Step ("Проверка значения итоговой суммы")
    public String getTotalPrice () {
        return driver.findElement(TOTAL_PRICE).getText();
    }

    @Step ("Нажатать кнопку 'Finish'")
    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

    @Step ("Проверка текста заглавия страницы")
    public String getCheckoutComplete () {
        return driver.findElement(CHECKOUT_COMPLETE).getText();
    }
}

