package ecommerce.tests;

import Constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

public class TestBase {

    public static String browser;
    public WebDriver driver;

//
//    public static void loginToSystem(WebDriver driver) {
//        navaigateToLoginPage(driver);
//        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//        loginPage.typeUsername(Constants.ADMIN_USERNAME);
//        loginPage.typePassword(Constants.ADMIN_PASSWORD);
//    }

    @Parameters("browser")
    @BeforeSuite(groups = {"smoke", "regression"})
    public void beforeSuite(@Optional("chrome") String browser) {
        TestBase.browser = browser;
    }

    @BeforeMethod(groups = {"smoke", "regression"})
    public void beforeMethod() {
        launchWebBrowser();
        setImplicitWait();
        maximizeBrowserWindow();
    }

    public void maximizeBrowserWindow() {
        driver.manage().window().fullscreen();
    }

    public void setImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT_IMPLICIT, TimeUnit.SECONDS);
    }

    public void launchWebBrowser() {
        driver = ecommerce.utils.WebDriverManagerUtils.launchWebBrowser(browser);
    }

    @AfterMethod(groups = {"smoke", "regression"})
    public void afterMethod() {
        driver.quit();
    }

    public void check(WebElement chkCreateLoginDetails) {
        if (!chkCreateLoginDetails.isSelected()) {
            chkCreateLoginDetails.click();
        }
    }

    public void uncheck(WebElement chkCreateLoginDetails) {
        if (chkCreateLoginDetails.isSelected()) {
            chkCreateLoginDetails.click();
        }
    }
}