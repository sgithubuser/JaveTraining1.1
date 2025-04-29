package testscripts.page;

import lib.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Training2_LoginPage {
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;
    //Locators
    private By btnSignIn = By.xpath("//a[contains(text(), 'Sign In')]");
    private By txtUserName = By.xpath("//input[@id='user-name']");
    private By txtPassword = By.xpath("//input[@id='password']");
    private By btnLogin = By.xpath("//input[@id='login-button']");
    private By  btnHamburger = By.id("react-burger-menu-btn");
    private By  btnLogout = By.id( "logout_sidebar_link");


    // Constructor
    public Training2_LoginPage(WebDriver driver, String url) {
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

    public void clickHamburger(){
        seleniumHelper.waitUntilElementVisible(btnHamburger, Duration.ofSeconds(60));
        seleniumHelper.click(btnHamburger);
    }

    public void clickLogout(){
        seleniumHelper.waitUntilElementVisible(btnLogout, Duration.ofSeconds(60));
        seleniumHelper.click(btnLogout);
    }


}
