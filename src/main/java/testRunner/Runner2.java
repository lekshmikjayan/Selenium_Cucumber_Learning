package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/main/java/features/signin.feature"},
		dryRun = true,
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		glue= "steps"
		
		)


public class Runner2 extends AbstractTestNGCucumberTests {

}
