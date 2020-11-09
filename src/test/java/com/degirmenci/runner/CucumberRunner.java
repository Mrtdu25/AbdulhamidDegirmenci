package com.degirmenci.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt",
                "html:target/cucumber-report.html",
        },
        features = "src/test/resources/features",
        glue = "com/degirmenci/step_definition",
        tags = "@TC11",
        dryRun =false,
        publish = false
)

public class CucumberRunner {





}
