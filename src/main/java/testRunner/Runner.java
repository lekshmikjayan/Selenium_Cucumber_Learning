package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features= {"src/main/java/features/signin.feature"},
		dryRun = !true,
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		glue = {"steps","hooks", "pages"},
		plugin = {"pretty", "html:FinalReport",
				"json:result/FinalReport.json",
				"junit:result/FinalReport.xml"},
		tags= "@reg"
		
		//plugin="com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		/*plugin = {"pretty","html:CucumberReports",
				"json:reports/result.json",
				"junit:reports/result.xml"
		}*/
		//tags = {"@smoke and @reg"}
		)

public class Runner extends AbstractTestNGCucumberTests {

}
