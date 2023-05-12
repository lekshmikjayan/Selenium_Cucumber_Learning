package hooks;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.DriverInstance;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.github.bonigarcia.wdm.WebDriverManager;

public class hookss {

	DriverInstance newdriver;
	
	public hookss(DriverInstance newdriver) {
		this.newdriver = newdriver;
	}
	
	@Before(order = 1)
	public void initialBeforeScenario(Scenario scenario) {
		System.out.println("Im first");
	}

	@After("@cleanCart")
	public void cleanup() {
		newdriver.getDriver().findElement(By.xpath("//body/app-root[1]/app-nav-bar[1]/mat-toolbar[1]/mat-toolbar-row[1]/div[3]/button[2]/span[1]/mat-icon[1]")).click();
		newdriver.getDriver().findElement(By.cssSelector("body.app-background:nth-child(2) div.container app-shoppingcart.ng-star-inserted:nth-child(2) div.docs-example-viewer-wrapper div.docs-example-viewer-title.mat-elevation-z2 div.docs-example-viewer-title-spacer div.ng-star-inserted:nth-child(2) > button.mat-focus-indicator.mat-elevation-z4.mat-raised-button.mat-button-base")).click();
		String caption = newdriver.getDriver().findElement(By.className("mat-card-title")).getText();
		Assert.assertEquals(caption, "Shopping cart is empty");
	
	}
	
	@Before
	public void demo(Scenario scenario) {
		System.out.println(scenario.getId());
		System.out.println(scenario.getName());
		System.out.println(scenario.getSourceTagNames());
	//	System.out.println(scenario.getUri());
		System.out.println(scenario.getClass());
		//System.out.println(scenario.getId());
	}
	
	@Before
	public void beforeSc(Scenario scenario) {

		WebDriverManager.chromedriver().setup();
	RemoteWebDriver	driver = new ChromeDriver();
	WebDriverWait	wait = new WebDriverWait(driver, 10);

	newdriver.setDriver(driver);
	newdriver.setWait(wait);
	
	driver.manage().window().maximize();
		driver.get("https://bookcart.azurewebsites.net/login");
		System.out.println(driver.getTitle());

		System.out.println("Scenario name is : " + scenario.getName());
	}

	@After
	public void aftrSc(Scenario scenario) {

		Boolean status = scenario.isFailed();
		System.out.println("Scenario passed: " + status);
		if (status) {
			byte[] scrnsht = newdriver.getDriver().getScreenshotAs(OutputType.BYTES);
			scenario.embed(scrnsht, "image/png");

		}

		newdriver.getDriver().quit();
	}
	
	@After(order=2)
	public void lastAfterScenario(Scenario scenario) {
		System.out.println("I maybe the last..>!");
	}

	@BeforeStep
	public void beforestep(Scenario scenario) {
		byte[] scrnsht = newdriver.getDriver().getScreenshotAs(OutputType.BYTES);
		scenario.embed(scrnsht, "image/png");

	}

	@AfterStep
	public void afterstep(Scenario scenario) {
		byte[] scrnsht = newdriver.getDriver().getScreenshotAs(OutputType.BYTES);
		scenario.embed(scrnsht, "image/png");

	}
}
