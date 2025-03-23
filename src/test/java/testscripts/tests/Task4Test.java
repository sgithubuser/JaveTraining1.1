package testscripts.tests;

import Constants.Constants;
import testscripts.page.Task4Page;
import lib.SeleniumHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import org.testng.Assert;


public class Task4Test extends TestBase {

    private static final Logger log = LogManager.getLogger(Task3Test.class);
    private Task4Page task4Page;
    private SeleniumHelper seleniumHelper;
    @Test(groups = {"smoke", "regression"})
    public void testTask4() {
        this.seleniumHelper = new SeleniumHelper(driver);
        task4Page = new Task4Page(driver);
        printURLTestResult(task4Page.getURL());
        printTitleTestResult(task4Page.getTitle(), "DuckDuckGo - Protection. Privacy. Peace of mind.");
        Assert.assertEquals(task4Page.getTitle(), "DuckDuckGo - Protection. Privacy. Peace of mind.");
        task4Page.typeIntoSearchField("BBC Urdu");
        task4Page.clickSearch();
        task4Page.getSearchResult();
        printTitleTestResult(task4Page.getTitle(), "BBC Urdu at DuckDuckGo");
        Assert.assertEquals(task4Page.getTitle(), "BBC Urdu at DuckDuckGo");
        task4Page.clickFirstSearchResult();
        Assert.assertEquals(task4Page.getHeaderTextOpenSearchedItem(), "BBC News,");
        seleniumHelper.reloadPage();
        Assert.assertEquals(task4Page.getHeaderTextOpenSearchedItem(), "BBC News,");
        seleniumHelper.goBack();
        Assert.assertEquals(task4Page.getTitle(), "BBC Urdu at DuckDuckGo");




    }











    private void printURLTestResult(String actualURL) {
        if (actualURL.equals(Constants.TASK4_URL)) {
            System.out.println("PASS: The URL matches the expected value.");
        } else {
            System.out.println("FAIL: The URL does not match the expected value.");
        }
    }

    // Method to check Title and print PASS or FAIL
    private void printTitleTestResult(String actualTitle, String expectedTitle) {
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("PASS: The page title is '"+actualTitle+"'.");
        } else {
            System.out.println("FAIL: The page title is not '"+actualTitle+"'.");
        }
    }
}