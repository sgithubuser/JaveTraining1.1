package testscripts.page;

import lib.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Training2_CurriculumPage {
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;

    private By inventoryName = By.cssSelector("div[data-test=\"inventory-item-name\"]");
    private By inventoryDescription = By.xpath("//div[@class='inventory_details_desc large_size']");
    private By txtInventoryPrice;


    // Constructor
    public Training2_CurriculumPage(WebDriver driver) {
        this.driver = driver;
        this.seleniumHelper = new SeleniumHelper(driver);

    }

    public boolean inventoryName(){
        seleniumHelper.waitUntilElementPresent(inventoryName, Duration.ofSeconds(60));
        return true;
    }

    public String inventoryDescription(){
        seleniumHelper.waitUntilElementPresent(inventoryDescription, Duration.ofSeconds(60));
        String Description = seleniumHelper.getText(inventoryDescription);
        return Description;
    }

    public  void setXpathForPrice(String InventoryPrice)
    {
        txtInventoryPrice = By.xpath("//div[@class='inventory_details_price' and normalize-space()='"+InventoryPrice+"']");

    }

    public boolean inventoryPrice(String InventoryPrice){
        setXpathForPrice(InventoryPrice);
        seleniumHelper.waitUntilElementPresent(txtInventoryPrice, Duration.ofSeconds(60));
        return true;
    }

}

