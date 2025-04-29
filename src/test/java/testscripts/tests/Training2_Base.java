package testscripts.tests;

import Constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import testscripts.page.Training2_LoginPage;
import testscripts.utils.WebDriverManagerUtils;

import java.util.concurrent.TimeUnit;
import utils.ConfigReader;
import org.testng.ITestResult;
import utils.ScreenshotUtil;


public class Training2_Base {
    public static String browser;
    public WebDriver driver;
    public Training2_LoginPage loginPage;

    private final String configPath = "src/test/java/training2_config.properties";

    @Parameters("browser")
    @BeforeSuite(groups = {"smoke", "regression"})
    public void beforeSuite(@Optional("chrome") String browser) {
        Training2_Base.browser = browser;
        ConfigReader.load(configPath);
    }

    @BeforeClass(groups = {"smoke", "regression"})
    public void beforeClass() {
        launchWebBrowser();
        setImplicitWait();
        maximizeBrowserWindow();
        loginToSystem();
    }

    public void maximizeBrowserWindow() {
        driver.manage().window().maximize();
    }

    public void setImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT_IMPLICIT, TimeUnit.SECONDS);
    }

    public void launchWebBrowser() {
        driver = WebDriverManagerUtils.launchWebBrowser(browser);
    }

    public void loginToSystem() {
        loginPage = new Training2_LoginPage(driver, ConfigReader.get("url")); // Ensure LOGIN_URL is defined in Constants
        loginPage.enterUsername(ConfigReader.get("username"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLogin();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtil.captureScreenshot(driver, result.getName());
        }
    }

    @AfterClass(groups = {"smoke", "regression"})
    public void afterClass() {
        if (driver != null) {
            loginPage.clickHamburger();
            loginPage.clickLogout();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.quit();
        }
    }
}
