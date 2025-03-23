package ecommerce.tests;

import ecommerce.page.Task2Page;
import org.testng.annotations.*;
import org.testng.Assert;


public class Task2Test extends TestBase {

    private Task2Page task2Page;
    @Test(groups = {"smoke", "regression"})
    public void testTask2() {
        task2Page = new Task2Page(driver);
        task2Page.typeChangeID("Typeing by ID");
        task2Page.typeChangeClassName("Typing by Class name");
        task2Page.typeChangeXpath("Typing XPath");
        task2Page.typeChangeName("Typing Name");
        task2Page.submitLinkText();
        //verifying a new page is landed by checking its header through partial link text
        Assert.assertTrue(task2Page.pageLandedAfterFormSubmitted());

//        try {
//            Thread.sleep(Long.parseLong("300000000000"));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
