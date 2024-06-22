package HomeWork4.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest  {
    @Test (groups = "withSuccessLogin",
            description = "Проверка добавления покупки в корзину")
    public void addToCartProductTest ()  {
        String productName = "Sauce Labs Onesie";
        Assert.assertEquals(productsPage.getProductPrice(productName), "$7.99");
        Assert.assertEquals(productsPage.getProductDescription(productName), "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
        productsPage.clickAddToCartButton(productName);
        productsPage.clickYourCart();
        Assert.assertEquals(yourCartPage.getProductDescription(productName), "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
    }
}
