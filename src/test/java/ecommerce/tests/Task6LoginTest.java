 package ecommerce.tests;

 import Constants.Constants;
 import ecommerce.page.Task4Page;
 import ecommerce.page.Task6LoginPage;
 import lib.SeleniumHelper;
 import org.apache.logging.log4j.LogManager;
 import org.apache.logging.log4j.Logger;
 import org.testng.Assert;
 import org.testng.annotations.BeforeTest;
 import org.testng.annotations.Test;

 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.util.Properties;


 public class Task6LoginTest extends TestBase {

     private static final Logger log = LogManager.getLogger(Task3Test.class);
     private Task6LoginPage task6LoginPage;
     private SeleniumHelper seleniumHelper;
     private Properties configProperties;

     @BeforeTest(groups = {"smoke", "regression"})
     public void beforeTest() throws IOException {
         FileInputStream fis = new FileInputStream("src/test/java/config.properties");
         configProperties = new Properties();
         configProperties.load(fis);


     }

     @Test(groups = {"smoke", "regression"})
     public void testTask6ValidLogin() {
         task6LoginPage = new Task6LoginPage(driver, configProperties.getProperty("url"));
         task6LoginPage.enterUsername(configProperties.getProperty("username"));
         task6LoginPage.enterPassword(configProperties.getProperty("password"));
         task6LoginPage.clickLogin();
         Assert.assertTrue(task6LoginPage.homePageHeader());
     }

     @Test(groups = {"smoke", "regression"})
     public void testTask6InvalidLogin() {
         task6LoginPage = new Task6LoginPage(driver, configProperties.getProperty("url"));
         task6LoginPage.enterUsername(configProperties.getProperty("invalidUsername"));
         task6LoginPage.enterPassword(configProperties.getProperty("invalidPassword"));
         task6LoginPage.clickLogin();
         Assert.assertEquals(task6LoginPage.invalidLoginMessage(),"Epic sadface: Username and password do not match any user in this service");
     }
 }