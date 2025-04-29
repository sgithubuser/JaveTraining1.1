package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    // Capture screenshot and save with test name and timestamp
    public static void captureScreenshot(WebDriver driver, String testName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "screenshots/" + testName + "_" + timestamp + ".png";

        try {
            File destFile = new File(screenshotPath);
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("📸 Screenshot captured: " + screenshotPath);
        } catch (IOException e) {
            System.err.println("❌ Failed to save screenshot: " + e.getMessage());
        }
    }
}
