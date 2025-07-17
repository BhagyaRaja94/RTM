package org.rtm.systemtest.cucumber.tankmaster.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.rtm.systemtest.cucumber.tankmaster.base.TestContext;
import org.rtm.systemtest.cucumber.tankmaster.managers.ScreenshotManager;
import org.rtm.systemtest.cucumber.tankmaster.pages.WatchListPage;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


public class WatchListPageStepDefs {
    private final TestContext testContext;
    private final WatchListPage watchListPage;
    private final ScreenshotManager screenshotManager;
    private final String pageScreenshotsFolderPath = System.getProperty("user.dir") + "/target/logs/pageScreenshots/";

    public WatchListPageStepDefs(TestContext context) {
        this.testContext = context;
        watchListPage = testContext.getPageObjectManager().getWatchListPage();
        screenshotManager = testContext.getScreenshotManager();
    }

    @Then("verify user is able to see tank with name {string} in watch list")
    public void userAddsTankToWatchlist(String tankName){
        int tankNumber = Integer.parseInt(tankName.replaceAll("\\D+", ""))-100;// Assuming tank names are like "Tank 100", "Tank 101", etc.
        watchListPage.navigateToWatchlist();
        int tankIndex = tankNumber - 1; // Adjusting index to be zero-based
        assertThat(watchListPage.getTankHeaderTitle(tankIndex).getText()).isEqualTo(tankName);
        screenshotManager.takePageScreenShot(pageScreenshotsFolderPath + "WatchList_" + LocalDateTime.now() + "_PageScreenshot.png");
    }

    @When("user removes tank with name {string} from watch list")
    public void userRemovesTankFromWatchlist(String tankName) {
        int tankNumber = Integer.parseInt(tankName.replaceAll("\\D+", ""))-100;// Assuming tank names are like "Tank 100", "Tank 101", etc.
        int tankIndex = tankNumber - 1; // Adjusting index to be zero-based
        assertThat(watchListPage.getTankHeaderTitle(tankIndex).getText()).isEqualTo(tankName);
        watchListPage.removeTankToWatchlist(tankIndex);
        screenshotManager.takePageScreenShot(pageScreenshotsFolderPath + "WatchList_" + LocalDateTime.now() + "_PageScreenshot.png");
    }

    @When("verify user is not able to see tank with name {string} in watch list")
    public void verifyTankRemovedFromWatchList(String tankName) {
        assertThat(watchListPage.getNoTankMessage().isDisplayed()).isTrue();

    }
}
