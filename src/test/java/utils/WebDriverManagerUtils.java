package ecommerce.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverManagerUtils {

    public static WebDriver launchWebBrowser(String browser) {
        WebDriver driver = null;

        try {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars");
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

                // Initialize WebDriver
                driver = new ChromeDriver(options);

            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();

            } else if (browser.equalsIgnoreCase("safari")) {
                driver = new SafariDriver();

            } else if (browser.equalsIgnoreCase("ie")) {
                driver = new InternetExplorerDriver();

            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();

            } else if (browser.equalsIgnoreCase("chrome-headless")) {

                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                driver = new ChromeDriver(options);

            } else if (browser.equalsIgnoreCase("firefox-headless")) {
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                driver = new FirefoxDriver(firefoxOptions);
            } else {
                throw new WebDriverException("Unsupported browser: " + browser);
            }
        } catch (WebDriverException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return driver;
    }
}
