package HomeWork4.tests;

import HomeWork4.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.InvokedListener;
import utils.TestListener;
import utils.DriverFactory;

import java.time.Duration;
@Listeners({InvokedListener.class, TestListener.class})
public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected YourCartPage yourCartPage;
    protected CheckoutInfoPage checkoutInfo;
    protected CheckoutOverviewPage checkoutOverviewPage;



    @BeforeClass(alwaysRun = true)
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) throws Exception {
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.yourCartPage = new YourCartPage(driver);
        this.checkoutInfo = new CheckoutInfoPage(driver);
        this.checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }
    @BeforeMethod(onlyForGroups = "withSuccessLogin")
    public void preConditionForGroup() {
        loginPage.login("standard_user", "secret_sauce");
    }
    @AfterMethod()
    public void postCondition() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        loginPage.open();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}
