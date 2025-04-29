package testscripts.page;


import lib.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Training2_HomePage {
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;

    private By homePageHeader = By.xpath("//div[@class='app_logo' and text()='Swag Labs']");
    private By homePageInventoryList = By.xpath("//div[@class='inventory_list']");
    private By inventoryItem;


    // Constructor
    public Training2_HomePage(WebDriver driver) {
        this.driver = driver;
        this.seleniumHelper = new SeleniumHelper(driver);

    }

    public boolean homePageLanded(){
        seleniumHelper.waitUntilElementVisible(homePageHeader, Duration.ofSeconds(60));
        return true;
    }

    public boolean inverntoryListLoaded(){
        seleniumHelper.waitUntilElementVisible(homePageInventoryList, Duration.ofSeconds(60));
        return true;
    }

    public  void setXpathForGender(String InventoryName)
    {
        inventoryItem = By.xpath("//div[@class='inventory_item_name ' and text()='"+InventoryName+"']");

    }

    public void selectInventoryItem(String InventoryName){
        setXpathForGender(InventoryName);
        seleniumHelper.waitUntilElementPresent(inventoryItem, Duration.ofSeconds(60));
        seleniumHelper.click(inventoryItem);
    }



}
