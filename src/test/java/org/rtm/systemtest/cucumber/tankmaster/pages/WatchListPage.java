package org.rtm.systemtest.cucumber.tankmaster.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.rtm.systemtest.cucumber.tankmaster.managers.WaitManager;

import java.util.List;

public class WatchListPage {
    private final WebDriver driver;
    private final WaitManager waitManager;


    public WatchListPage(WebDriver driver, WaitManager waitManager) {
        this.driver = driver;
        this.waitManager = waitManager;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "WatchlistButtonId")
    WebElement watchlistTab;

    public void navigateToWatchlist() {
        waitManager.waitForVisibility(watchlistTab);
        watchlistTab.click();
        waitManager.setupFluentWait().until(x -> driver.findElement(By.xpath("//span[contains(text(), 'Watchlist')]")));
    }

    public WebElement getTankHeaderTitle(int tankIndex) {
        List<WebElement> tankHeaderTitles = driver.findElements(By.className("titlecard"));
        return tankHeaderTitles.get(tankIndex);
    }

    public void removeTankToWatchlist( int tankIndex) {
        List<WebElement> starIcons = driver.findElements(By.id("fa-star-solid-AId"));
        starIcons.get(tankIndex).click();
    }

    public WebElement getNoTankMessage() {
        return waitManager.setupFluentWait().until(x -> driver.findElement(By.id("EmptyWatchlistAId")));
    }



}

