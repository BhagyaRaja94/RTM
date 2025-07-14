package org.rtm.systemtest.cucumber.tankmaster;

import org.rtm.systemtest.cucumber.tankmaster.base.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

import java.time.LocalDateTime;


public class CucumberHooks {
    private final TestContext testContext;

    private final String failureScreenshotsFolderPath = System.getProperty("user.dir") + "/target/logs/failureScreenshots/";


    public CucumberHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @AfterStep
        public void takePageScreenShotOnStepFailure(Scenario scenario) {
            if (scenario.isFailed()) {
                testContext.getScreenshotManager()
                    .takePageScreenShot(
                        failureScreenshotsFolderPath + scenario.getName().trim() + "_" + LocalDateTime.now() + "_failedStep_PageScreenshot.png");
            }
        }

    @After(order = 1)
    public void closeBrowser() {
        testContext.getWebDriverManager().quitDriver();
    }
}
