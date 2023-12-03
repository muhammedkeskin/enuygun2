package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"json:target/cucumber.json",
                "html:target/enuygun-html-reports",
                "rerun:target/rerun.txt"
        },

        features = "src/test/resources/features",
        glue = "step_definitions",
        dryRun = false,
        tags = "@enuygun"
)

public class CukesRunner {
}
