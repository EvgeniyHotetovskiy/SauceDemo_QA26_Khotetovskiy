package HomeWork4.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test (groups = {"regression", "withSuccessLogin"},
            description = "Успешная авторизация в приложении")
    public void positiveLoginTest(){
        Assert.assertTrue(productsPage.isShoppingCardDisplayed());
    }
    @Test(groups = "regression",
            dataProvider = "Негативные тестовые данные для логина",
            description = "Негативный тест на авторизацию и проверка сообщения об ошибке")
    public void negativeLoginTest(String email, String password, String errorMessage) {
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isDisplayMessageError());
        Assert.assertEquals(loginPage.getErrorText(), errorMessage);
    }

    @DataProvider(name = "Негативные тестовые данные для логина")
    public Object[][] testDataForLoginTest() {
        return new Object[][]{
                {"123dsa", "fsd", "Epic sadface: Username and password do not match any user in this service"},
                {"123sdf", "", "Epic sadface: Password is required"},
                {"", "123sdf", "Epic sadface: Username is required"},
                {"", "", "Epic sadface: Username is required"}
        };

    }
}
