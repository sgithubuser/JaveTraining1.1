package ecommerce.page;

import Constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import lib.SeleniumHelper;

import java.time.Duration;

public class Task6LoginPage {

    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    private By txtUserName = By.xpath("//input[@id='user-name']");
    private By txtPassword = By.xpath("//input[@id='password']");
    private By btnLogin = By.xpath("//input[@id='login-button']");
    private By headerHomePage = By.xpath("//*[text()='Products']");
    private By errorMessage = By.cssSelector("h3[data-test='error']");


    // Constructor
    public Task6LoginPage(WebDriver driver, String url) {
        this.driver = driver;
        this.seleniumHelper = new SeleniumHelper(driver);
        driver.get(url);
    }

    public void enterUsername(String userName){
        seleniumHelper.waitUntilElementVisible(txtUserName, Duration.ofSeconds(60));
        seleniumHelper.sendKeys(txtUserName, userName);
    }

    public void enterPassword(String password){
        seleniumHelper.waitUntilElementVisible(txtPassword, Duration.ofSeconds(60));
        seleniumHelper.sendKeys(txtPassword, password);
    }

    public void clickLogin(){
        seleniumHelper.waitUntilElementVisible(btnLogin, Duration.ofSeconds(60));
        seleniumHelper.click(btnLogin);
    }

    public boolean homePageHeader(){
        seleniumHelper.waitUntilElementPresent(headerHomePage, Duration.ofSeconds(60));
        return true;
    }

    public String invalidLoginMessage(){
        seleniumHelper.waitUntilElementPresent(errorMessage, Duration.ofSeconds(60));
        return seleniumHelper.getText(errorMessage);
    }

}
