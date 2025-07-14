package org.rtm.systemtest.cucumber.tankmaster.managers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotManager {
    private final WebDriver driver;

    public ScreenshotManager(WebDriver driver) {
        this.driver = driver;
    }

    public void takePageScreenShot(String filePath) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        try {
            FileUtils.copyFile(scrShot.getScreenshotAs(OutputType.FILE), new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Copying file does not work " + e.getMessage());
        }
    }
}
