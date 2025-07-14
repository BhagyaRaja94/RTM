package org.rtm.systemtest.cucumber.tankmaster;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources",
    glue = {"org.rtm.systemtest.cucumber.tank_master"},
    plugin = {"pretty",
        "com.az.ip.dmdp.systemtest.cucumber.commons.FeatureScenarioLogger",
        "rerun:target/failed_scenarios.txt"
    },
    tags = "not @WIP")
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
