package org.rtm.systemtest.cucumber.tankmaster.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rtm.systemtest.cucumber.tankmaster.managers.WaitManager;

import java.util.List;


public class UserOverviewPage {
    private WebDriver driver;
    private final WaitManager waitManager;


    public UserOverviewPage(WebDriver driver, WaitManager waitManager) {
        this.driver = driver;
        this.waitManager = waitManager;
        PageFactory.initElements(driver, this);
    }

    public void addTankToWatchlist( int tankIndex) {
        List<WebElement> watchIcons = driver.findElements(By.cssSelector(".watch-icon.svg-inline--fa.fa-star.fa-w-18"));
        watchIcons.get(tankIndex).click();
    }

    public WebElement getProfileSpan(String profile) {
        return waitManager.setupFluentWait().until(x -> driver.findElement(By.xpath("//span[contains(text(), '" + profile + "')]")));
    }

    public WebElement getAllTanksTab() {
        return waitManager.setupFluentWait().until(x -> driver.findElement(By.xpath("//span[contains(text(), 'All Tanks')]")));
    }
}

