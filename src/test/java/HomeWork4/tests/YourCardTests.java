package HomeWork4.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YourCardTests extends BaseTest {
    @Test (groups = "smoke",  dataProvider = "testDataForAddProductToCard",
            description = "Проверка параметров добавленных в корзину товаров")
    public void yourCardTest (String product)  {
        productsPage.clickAddToCartButton(product);
        productsPage.clickYourCart();
        Assert.assertTrue(yourCartPage.isShoppingCardDisplayed());
        Assert.assertTrue(yourCartPage.productInCard(product), "проверка продукта");
    }
    @DataProvider
    public Object[][] testDataForAddProductToCard() {
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
                {"Sauce Labs Onesie"},
                {"Test.allTheThings() T-Shirt (Red)"}
        };
    }
}
