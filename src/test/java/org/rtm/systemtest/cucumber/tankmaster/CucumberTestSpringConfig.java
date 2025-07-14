package org.rtm.systemtest.cucumber.tankmaster;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.rtm.systemtest.cucumber.tankmaster.base.TestContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.annotation.ComponentScan;

@CucumberContextConfiguration
@ContextConfiguration(classes = {CucumberTestSpringConfig.class, TestContext.class})
@ComponentScan(basePackageClasses = {CucumberTestSpringConfig.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberTestSpringConfig {
}
