package testscripts.page;

import lib.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Constants.Constants;

import java.time.Duration;

public class Task4Page {
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;

    // Locators
    private By txtSearchField = By.xpath("//input[@aria-label = 'Search with DuckDuckGo']");
    private By btnSearch = By.xpath("//button[@aria-label = 'Search']");
    private By btnSearchedResultPage = By.xpath("//a[@id='header-logo-wrapper']");
    private By btnFirstSearchedResultItem = By.xpath("(//ol[@class='react-results--main']//li//h2//a)[1]");
    private By logoBBC = By.xpath("//span[@id='BrandLink-topPage']//span[@lang]");




    // Constructor
    public Task4Page(WebDriver driver) {
        this.driver = driver;
        this.seleniumHelper = new SeleniumHelper(driver);
        driver.get(Constants.TASK4_URL);
    }

    public String getTitle() {
        return seleniumHelper.getPageTitle();

    }
    public String getURL() {
        return seleniumHelper.getCurrentUrl();
    }

    public void typeIntoSearchField(String searchedText){
        seleniumHelper.waitUntilElementVisible(txtSearchField, Duration.ofSeconds(30));
        seleniumHelper.sendKeys(txtSearchField, searchedText);
    }

    public void clickSearch(){
        seleniumHelper.waitUntilElementVisible(txtSearchField, Duration.ofSeconds(30));
        seleniumHelper.click(btnSearch);
    }

    public void getSearchResult(){
        seleniumHelper.waitUntilElementVisible(btnSearchedResultPage, Duration.ofSeconds(30));
    }

    public void clickFirstSearchResult(){
        seleniumHelper.waitUntilElementVisible(btnFirstSearchedResultItem, Duration.ofSeconds(30));
        seleniumHelper.click(btnFirstSearchedResultItem);
    }

    public String getHeaderTextOpenSearchedItem(){
        seleniumHelper.waitUntilElementVisible(logoBBC, Duration.ofSeconds(30));
        return seleniumHelper.getText(logoBBC);
    }

}
