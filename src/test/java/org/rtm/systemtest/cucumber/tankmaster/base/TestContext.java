package org.rtm.systemtest.cucumber.tankmaster.base;

import io.cucumber.spring.ScenarioScope;
import org.rtm.systemtest.cucumber.tankmaster.managers.PageObjectManager;
import org.rtm.systemtest.cucumber.tankmaster.managers.ScreenshotManager;
import org.rtm.systemtest.cucumber.tankmaster.managers.WaitManager;
import org.rtm.systemtest.cucumber.tankmaster.managers.WebDriverManager;
import org.springframework.stereotype.Service;

@Service
@ScenarioScope
public class TestContext {
    private final WebDriverManager webDriverManager;
    private final PageObjectManager pageObjectManager;
    private final ScreenshotManager screenshotManager;

    public TestContext() {
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver(), new WaitManager(webDriverManager.getDriver()));
        screenshotManager = new ScreenshotManager(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScreenshotManager getScreenshotManager() {
        return screenshotManager;
    }
}
