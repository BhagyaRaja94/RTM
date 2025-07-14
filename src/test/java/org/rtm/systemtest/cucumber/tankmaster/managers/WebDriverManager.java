package org.rtm.systemtest.cucumber.tankmaster.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Optional;


import static java.time.temporal.ChronoUnit.SECONDS;

public class WebDriverManager {
    private WebDriver driver;


    public WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();

            Boolean setHeadlessFlag = Optional.ofNullable(System.getenv("BROWSER_CONFIG_HEADLESS")).map(Boolean::valueOf).orElse(false);
            if (setHeadlessFlag.equals(true)) {
                options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu");
            }
            options.addArguments("--start-maximized");
            options.setImplicitWaitTimeout(Duration.of(60, SECONDS));
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}
