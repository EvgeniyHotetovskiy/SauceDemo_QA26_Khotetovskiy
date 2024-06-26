package HomeWork4.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class YourCartPage extends BasePage {

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    private final static By QTY = By.className("cart_quantity_label");
    private final static By CHECKOUT = By.id("checkout");
    private final static String ITEM_CONTAINER = "//div[text()='%s']/ancestor::div[@class='cart_item_label']";
    private final static By ITEM_PRICE = By.className("inventory_item_price");
    private final static By ITEM_DESCRIPTION = By.className("inventory_item_desc");
    private final By ALL_ITEM = By.className("inventory_item_name");

    @Step("Проверка отображения корзины с товарами")
    public boolean isShoppingCardDisplayed() {
        return driver.findElement(QTY).isDisplayed();
    }

    @Step("Нажать на кнопку 'Checkout'")
    public void clickCheckout() {
        driver.findElement(CHECKOUT).click();
    }

    @Step("Проверка отображения корзины с покупками")
    public String getProductPrice(String productName) {
        return this.getProductCardByName(productName).findElement(ITEM_PRICE).getText();
    }

    public String getProductDescription(String productName) {
        return this.getProductCardByName(productName).findElement(ITEM_DESCRIPTION).getText();
    }

    private WebElement getProductCardByName(String productName) {
        return driver.findElement(By.xpath(String.format(ITEM_CONTAINER, productName)));
    }

    @Step("Проверка отображения списка товаров на странице")
    public boolean productInCard(String productName) {
        List<WebElement> webElementList = driver.findElements(ALL_ITEM);
        boolean flag = false;
        for (WebElement i : webElementList) {
            if (i.getText().equals(productName)) {
                flag= true;
            }
        }
        return flag;
    }
}