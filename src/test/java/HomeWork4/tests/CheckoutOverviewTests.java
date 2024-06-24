package HomeWork4.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTests extends BaseTest{
    @Test(groups = "smoke",
            description = "Проверка полной стоимости продукта, таксы + успешная покупка")
    public void checkoutOverviewTest ()  {
        String productName = "Sauce Labs Onesie";
        String productName2 = "Sauce Labs Backpack";
        productsPage.clickAddToCartButton(productName);
        productsPage.clickAddToCartButton(productName2);
        productsPage.clickYourCart();
        yourCartPage.clickCheckout();
        checkoutInfo.setYourInformation("Jonh", "Smith", "222160");
        Assert.assertEquals(checkoutOverviewPage.getTotalPrice(), "Total: $41.02");
        checkoutOverviewPage.clickFinishButton();
        Assert.assertEquals(checkoutOverviewPage.getCheckoutComplete(), "Checkout: Complete!");
    }
}
