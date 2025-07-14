package org.rtm.systemtest.cucumber.tankmaster.stepdefinitions;

import io.cucumber.java.en.Then;
import org.rtm.systemtest.cucumber.tankmaster.base.TestContext;
import org.rtm.systemtest.cucumber.tankmaster.managers.ScreenshotManager;
import org.rtm.systemtest.cucumber.tankmaster.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageStepDefs {
    private final TestContext testContext;
    private final LoginPage loginPage;
    private final ScreenshotManager screenshotManager;
    private final String pageScreenshotsFolderPath = System.getProperty("user.dir") + "/target/logs/pageScreenshots/";

    public LoginPageStepDefs(TestContext context) {
        this.testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        screenshotManager = testContext.getScreenshotManager();
    }

    @Given("user has launched Tank Master application in the browser")
    public void userLaunchedTankMasterInBrowser() throws IOException {
        loginPage.navigateToLoginPage();
        assertThat(loginPage.getPageTitle()).isEqualTo("Rosemount TankMaster Mobile - Signin");
        screenshotManager.takePageScreenShot(pageScreenshotsFolderPath + "Login_" + LocalDateTime.now() + "_PageScreenshot.png");
    }

    @When("user enters valid email and password on the Login page")
    public void userLogsInTankMaster() {
        String email = "operator@example.com";
        String password = "Pass123!";
        loginPage.performLogin(email, password);
    }

    @When("user enters email {string} and password {string} on the Login page")
    public void userLogsInTankMaster(String email, String password) {
        loginPage.performLogin(email, password);
    }

    @Then("verify user is not logged in and error message is displayed")
    public void userNotLoggedInTankMaster() {
        assertThat(loginPage.getLoginErrorMessage().isDisplayed()).isTrue();
    }
}
