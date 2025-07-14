package org.rtm.systemtest.cucumber.tankmaster.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.rtm.systemtest.cucumber.tankmaster.base.TestContext;
import org.rtm.systemtest.cucumber.tankmaster.managers.ScreenshotManager;
import org.rtm.systemtest.cucumber.tankmaster.pages.UserOverviewPage;


import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class UserOverviewPageStepDefs {
    private final TestContext testContext;
    private final UserOverviewPage userOverviewPage;
    private final ScreenshotManager screenshotManager;
    private final String pageScreenshotsFolderPath = System.getProperty("user.dir") + "/target/logs/pageScreenshots/";

    public UserOverviewPageStepDefs(TestContext context) {
        this.testContext = context;
        userOverviewPage = testContext.getPageObjectManager().getUserOverviewPage();
        screenshotManager = testContext.getScreenshotManager();
    }

    @Then("verify {string} user is logged in successfully with user name displayed on the page")
    public void verifyUserIsLoggedIn(String userName) {
        assertThat(userOverviewPage.getProfileSpan(userName).isDisplayed()).isTrue();

        screenshotManager.takePageScreenShot(pageScreenshotsFolderPath + "Overview_" + LocalDateTime.now() + "_PageScreenshot.png");
    }

    @Then("verify user is able to see all tanks tab selected in over view screen")
    public void verifyUserAbleToSeeAllTanksTabDisplayed() {

        assertThat(userOverviewPage.getAllTanksTab().isDisplayed()).isTrue();
        screenshotManager.takePageScreenShot(pageScreenshotsFolderPath + "Overview_" + LocalDateTime.now() + "_PageScreenshot.png");
    }

    @When("user adds tank with name {string} to watch list")
    public void userAddsTankToWatchlist(String tankName) {
        int tankNumber = Integer.parseInt(tankName.replaceAll("\\D+", ""))-100;// Assuming tank names are like "Tank 100", "Tank 101", etc.
        int tankIndex= tankNumber - 1; // Adjusting index to be zero-based
        userOverviewPage.addTankToWatchlist(tankIndex);
        System.out.println(tankName  +  tankIndex);
        screenshotManager.takePageScreenShot(pageScreenshotsFolderPath + "Overview_" + LocalDateTime.now() + "_PageScreenshot.png");
    }
}
