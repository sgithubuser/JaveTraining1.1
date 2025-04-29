package testscripts.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.page.Training2_CurriculumPage;
import testscripts.page.Training2_HomePage;



public class Training2_Task extends Training2_Base{
    private  Training2_CurriculumPage training2CurriculumPage;
    private Training2_HomePage training2HomePage;


    @Test(groups = {"smoke", "regression"})
    public void training2Task() {
        training2HomePage = new Training2_HomePage(driver);
        training2CurriculumPage = new Training2_CurriculumPage(driver);
        Assert.assertTrue(training2HomePage.homePageLanded());
        Assert.assertTrue(training2HomePage.inverntoryListLoaded());
        training2HomePage.selectInventoryItem("Sauce Labs Bike Light");
        Assert.assertTrue(training2CurriculumPage.inventoryName());
        Assert.assertTrue(training2CurriculumPage.inventoryPrice("$9.99"));
        String inventoryDescription = training2CurriculumPage.inventoryDescription();
        System.out.println(inventoryDescription);
    }




    }

