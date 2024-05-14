package HomeWork4.tests;

import HomeWork4.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected YourCartPage yourCartPage;
    protected CheckoutInfo checkoutInfo;
    protected CheckoutOverviewPage checkoutOverviewPage;



    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.yourCartPage = new YourCartPage(driver);
        this.checkoutInfo = new CheckoutInfo(driver);
        this.checkoutOverviewPage = new CheckoutOverviewPage(driver);
        loginPage.open();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}
