package HomeWork4.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest  {
    @Test
    public void addToCartProductTest ()  {
        String productName = "Sauce Labs Onesie";
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getProductPrice(productName), "$7.99");
        Assert.assertEquals(productsPage.getProductDescription(productName), "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
        productsPage.clickAddToCartButton(productName);
        Assert.assertEquals(productsPage.getNameOfButtonRemoveProduct(productName), "Remove", "Button is not select");
    }
}
