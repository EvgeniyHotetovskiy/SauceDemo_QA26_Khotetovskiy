package HomeWork4.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class YourCardTests extends BaseTest {
    @Test
    public void YourCardTest ()  {
        String productName = "Sauce Labs Onesie";
        String productName2 = "Sauce Labs Backpack";
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton(productName);
        productsPage.clickAddToCartButton(productName2);
        productsPage.clickYourCart();
        Assert.assertTrue(yourCartPage.isShoppingCardDisplayed());
        Assert.assertEquals(yourCartPage.getProductPrice(productName), "$7.99");
        Assert.assertEquals(yourCartPage.getProductDescription(productName), "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
        Assert.assertEquals(yourCartPage.getProductPrice(productName2), "$29.99");
        Assert.assertEquals(yourCartPage.getProductDescription(productName2), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        yourCartPage.clickCheckout();
        Assert.assertEquals(checkoutInfo.getCheckoutInfo(), "Checkout: Your Information");
    }
}
