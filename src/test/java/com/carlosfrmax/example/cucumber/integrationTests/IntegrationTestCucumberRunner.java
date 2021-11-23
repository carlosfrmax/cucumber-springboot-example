package com.carlosfrmax.example.cucumber.integrationTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/integrationTests",
        plugin = {"pretty", "html:target/cucumber"})
public class IntegrationTestCucumberRunner {
}
