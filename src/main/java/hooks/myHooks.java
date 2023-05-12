package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.github.bonigarcia.wdm.WebDriverManager;

public class myHooks {

	private PageContext context;
	
	public myHooks(PageContext context) {
		this.context = context;
	}
	
	@Before(order=1)
	public void beforeScenario(Scenario scenario) {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		context.setDriver(driver);
		context.setDriverWait(wait);
		//	Thread.sleep(2000);
			context.getDriver().get("https://rahulshettyacademy.com/client/auth/login");
		//	wait = new WebDriverWait(driver, 10);
			context.getDriver().manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			System.out.println(driver.getTitle());
			
			//scenario methods
			System.out.println(scenario.getName());
			System.out.println(scenario.getId());
			System.out.println(scenario.getSourceTagNames());
			System.out.println(scenario.getStatus());
	//		System.out.println(scenario.getUri());
	//		System.out.println(scenario.getLines());
	}
	@After
	public void afterScenario(Scenario scenario) {
		boolean status = scenario.isFailed();
		if(status) {
		byte[]	scrnsht = context.getDriver().getScreenshotAs(OutputType.BYTES);
		scenario.embed(scrnsht, "img/png");
		}
		context.getDriver().quit();
	}
	@BeforeStep
	public void beforestep() {

	}
	@AfterStep
	public void afterstep() {

	}
}
