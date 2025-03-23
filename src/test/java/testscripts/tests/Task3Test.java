package testscripts.tests;

import testscripts.page.Task3Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import org.testng.Assert;


public class Task3Test extends TestBase {

    private static final Logger log = LogManager.getLogger(Task3Test.class);
    private Task3Page task3Page;
    @Test(groups = {"smoke", "regression"})
    public void testTask3() {
        task3Page = new Task3Page(driver);
        task3Page.typefirstName("Typeing by ID");
        task3Page.typeLastName("type last name");
        task3Page.typeEmail("salman@example.com");
        task3Page.selectGender("Male");
        task3Page.typePhone("0008997880");
        task3Page.typeAddress("St 108");
        task3Page.clickSubmit();
        Assert.assertEquals(task3Page.getTextSubmissionModalHeader(), "Thanks for submitting the form");



    }
}
