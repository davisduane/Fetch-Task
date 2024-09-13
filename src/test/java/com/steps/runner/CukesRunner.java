package com.steps.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "com/steps/stepDefinitions",
        dryRun = true,
        tags = "@loc") // Replace with your package name
public class CukesRunner {
}
