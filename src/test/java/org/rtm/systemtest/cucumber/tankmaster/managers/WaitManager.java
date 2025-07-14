package org.rtm.systemtest.cucumber.tankmaster.managers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitManager {
    private final WebDriver driver;

    public WaitManager(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisibility(WebElement element) throws Error {
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(element));
    }

    public Wait<WebDriver> setupFluentWait() throws Error {
        return new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(StaleElementReferenceException.class)
            .ignoring(NoSuchElementException.class);
    }
}
