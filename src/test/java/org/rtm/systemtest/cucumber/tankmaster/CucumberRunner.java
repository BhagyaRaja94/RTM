package org.rtm.systemtest.cucumber.tankmaster;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"org.rtm.systemtest.cucumber.tank_master"},
    plugin = {"pretty",
        "com.az.ip.dmdp.systemtest.cucumber.commons.FeatureScenarioLogger",
        "rerun:target/failed_scenarios.txt",
        "html:target/cucumber-reports/cucumber.html",
    }
    )
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

