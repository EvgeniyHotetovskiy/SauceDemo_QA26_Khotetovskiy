package HomeWork4.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By EMAIL_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("h3[data-test=error]");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть сайт SauceDemo")
    public void open () {
        driver.get("https://www.saucedemo.com/");
    }

    @Step ("Ввести значение в поле email - {'email'}")
    public void setEmailValue(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    @Step ("Ввести значение в поле пароля - {'password'}")
    public void setPasswordValue(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step ("Нажать кнопку авторизации")
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step ("Авторизироваться с логином {'email'} и паролем {'password'}")
    public void login(String email, String password) {
        setEmailValue(email);
        setPasswordValue(password);
        clickLoginButton();
    }

    @Step ("Проверка отображения ошибки авторизации")
    public boolean isDisplayMessageError() {
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    @Step ("Проверка текста ошибки авторизации")
    public String getErrorText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

}
