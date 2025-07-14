package org.rtm.systemtest.cucumber.tankmaster;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.rtm.systemtest.cucumber.tankmaster.base.TestContext;


@CucumberContextConfiguration
@ContextConfiguration(classes = {CucumberTestSpringConfig.class, TestContext.class})
@ComponentScan(basePackageClasses = {CucumberTestSpringConfig.class})

public class CucumberTestSpringConfig {
}
