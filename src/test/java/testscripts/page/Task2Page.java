package testscripts.page;

import lib.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Constants.Constants;

import java.time.Duration;

public class Task2Page {
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;

    // Locators
    private By changeID = By.id("change_id");
    private By changeClassName = By.className("test_class");
    private By changeTag = By.tagName("test_tag");
    private By changeXpath = By.xpath("//textarea[@placeholder ='Change: Enabled to disabled']");
    private By changeName = By.name("change_name");
    private By changeLinkText = By.linkText("Change: LinkText, PartialLinkText");
    private By changePartialLinkText = By.partialLinkText("How it w");

    // Constructor
    public Task2Page(WebDriver driver) {
        this.driver = driver;
        this.seleniumHelper = new SeleniumHelper(driver);
        driver.get(Constants.TASK2_URL);
    }

    public void typeChangeID(String id) {
        seleniumHelper.waitUntilElementVisible(changeID, Duration.ofSeconds(30));
        seleniumHelper.sendKeys(changeID, id );

    }

    public void typeChangeClassName(String classname) {
        seleniumHelper.waitUntilElementVisible(changeClassName, Duration.ofSeconds(60));
        seleniumHelper.sendKeys(changeClassName, classname );
    }

    public void typeChangeTag(String tagname) {
        seleniumHelper.waitUntilElementVisible(changeTag, Duration.ofSeconds(60));
        seleniumHelper.sendKeys(changeTag, tagname );
    }

    public void typeChangeXpath(String xpath) {
        seleniumHelper.waitUntilElementVisible(changeXpath, Duration.ofSeconds(60));
        seleniumHelper.sendKeys(changeXpath, xpath );
    }

    public void typeChangeName(String name) {
        seleniumHelper.waitUntilElementVisible(changeName, Duration.ofSeconds(60));
        seleniumHelper.sendKeys(changeName, name );
    }

    public void submitLinkText(){
        seleniumHelper.waitUntilElementVisible(changeLinkText, Duration.ofSeconds(60));
        seleniumHelper.click(changeLinkText);
    }

    public boolean pageLandedAfterFormSubmitted(){
        seleniumHelper.waitUntilElementVisible(changePartialLinkText, Duration.ofSeconds(60));
        return true;

    }

}
