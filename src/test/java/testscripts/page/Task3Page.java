package testscripts.page;

import lib.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Constants.Constants;

import java.time.Duration;

public class Task3Page {
    private WebDriver driver;
    private SeleniumHelper seleniumHelper;

    // Locators
    private By txtFirstName = By.xpath("//input[@placeholder='First Name']");
    private By txtLastName = By.xpath("//input[contains(@placeholder,'Last') or @id='lastName']");     //xpath created using contains and OR
    private By txtEmail = By.xpath("//label[text()='Email']//ancestor::div[@id='userEmail-wrapper']//input");   //xpath created using traversal from node and text()
    static By chkboxGender ;     //dynamic xpath
    private By txtPhone = By.xpath("(//input)[7]");  //using index
    private By txtAddress = By.xpath("//*[contains(@placeholder, 'Current Address')]"); //wildcard
    private By btnSubmit = By.xpath("//button[@id='submit']");
    private By submissionDetailModalHeader = By.xpath("//div[contains(@class, 'modal-title')]");


    // Constructor
    public Task3Page(WebDriver driver) {
        this.driver = driver;
        this.seleniumHelper = new SeleniumHelper(driver);
        driver.get(Constants.TASK3_URL);
    }

    public void typefirstName(String firstName) {
        seleniumHelper.waitUntilElementVisible(txtFirstName, Duration.ofSeconds(30));
        seleniumHelper.sendKeys(txtFirstName, firstName );

    }

    public void typeLastName(String lastName) {
        seleniumHelper.waitUntilElementVisible(txtLastName, Duration.ofSeconds(60));
        seleniumHelper.sendKeys(txtLastName, lastName );
    }

    public void typeEmail(String email) {
        seleniumHelper.waitUntilElementVisible(txtEmail, Duration.ofSeconds(60));
        seleniumHelper.sendKeys(txtEmail, email );
    }

    private static void setXpathForGender(String Gender)
    {
        chkboxGender = By.xpath("//input[@name='gender' and @value='"+Gender+"']");

    }

    public void selectGender(String Gender){
        setXpathForGender(Gender);
        seleniumHelper.waitUntilElementPresent(chkboxGender, Duration.ofSeconds(60));
        seleniumHelper.click(chkboxGender);
    }

    public void typePhone(String phone) {
        seleniumHelper.waitUntilElementVisible(txtPhone, Duration.ofSeconds(60));
        seleniumHelper.sendKeys(txtPhone, phone );
    }

    public void typeAddress(String address) {
        seleniumHelper.waitUntilElementVisible(txtAddress, Duration.ofSeconds(60));
        seleniumHelper.sendKeys(txtAddress, address );
    }

    public void clickSubmit(){
        seleniumHelper.waitUntilElementVisible(btnSubmit, Duration.ofSeconds(60));
        seleniumHelper.click(btnSubmit);
    }

    public String getTextSubmissionModalHeader(){
        seleniumHelper.waitUntilElementVisible(submissionDetailModalHeader, Duration.ofSeconds(60));
        return  seleniumHelper.getText(submissionDetailModalHeader);
    }


}
