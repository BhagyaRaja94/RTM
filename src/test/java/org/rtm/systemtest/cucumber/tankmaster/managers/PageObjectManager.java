package org.rtm.systemtest.cucumber.tankmaster.managers;

import org.openqa.selenium.WebDriver;
import org.rtm.systemtest.cucumber.tankmaster.pages.LoginPage;
import org.rtm.systemtest.cucumber.tankmaster.pages.UserOverviewPage;
import org.rtm.systemtest.cucumber.tankmaster.pages.WatchListPage;

public class PageObjectManager {
    private final WebDriver driver;
    private final WaitManager waitManager;

    private LoginPage loginPage;
    private UserOverviewPage userOverviewPage;
    private WatchListPage watchListPage;


    public PageObjectManager(WebDriver driver, WaitManager waitManager) {
        this.driver = driver;
        this.waitManager = waitManager;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver, waitManager) : loginPage;
    }

    public UserOverviewPage getUserOverviewPage() {
        return (userOverviewPage == null) ? userOverviewPage = new UserOverviewPage(driver, waitManager) : userOverviewPage;
    }

    public WatchListPage getWatchListPage() {
        return (watchListPage == null) ? watchListPage = new WatchListPage(driver, waitManager) : watchListPage;
    }
}

