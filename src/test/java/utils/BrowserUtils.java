package utils;

import org.openqa.selenium.WebDriver;

public class BrowserUtils {
    public static void switchToWindowByTitle(WebDriver driver, String title) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    public static void closeAllOtherWindows(WebDriver driver) {
        String originalWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(originalWindow);
    }
}
