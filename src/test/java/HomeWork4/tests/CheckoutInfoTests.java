package HomeWork4.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutInfoTests extends BaseTest {
    @Test
    public void CheckoutInfoTest ()  {
        String productName = "Sauce Labs Onesie";
        String productName2 = "Sauce Labs Backpack";
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton(productName);
        productsPage.clickAddToCartButton(productName2);
        productsPage.clickYourCart();
        yourCartPage.clickCheckout();
        checkoutInfo.setYourInformation("Jonh", "Smith", "222160");
        Assert.assertEquals(checkoutOverviewPage.getCheckoutOverview(), "Checkout: Overview");
    }
}
