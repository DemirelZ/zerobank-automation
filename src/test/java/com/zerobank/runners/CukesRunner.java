package com.zerobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target/default-html-report.html",
                "json:target/cucumber.json"

        },

        features = "src/test/resources/features",
        glue = "com/zerobank/stepDefinitions",
        dryRun = false,
        tags = "@wip6"

)
public class CukesRunner {

}
