package steps;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.DriverInstance;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps extends hooks.DriverInstance {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("User navigate to Practise application")
	public void userNavigateToPractiseApplication() {
WebDriverManager.chromedriver().setup();
		
	//	Thread.sleep(2000);
		driver.get("https://rahulshettyacademy.com/client/auth/login");
	//	wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
	}

	/*
	 * @And("user enter username") public void userEnterUsername() {
	 * driver.findElement(By.id("userEmail")).sendKeys("milton@abc.com"); }
	 * 
	 * @And("user eneterd password") public void userEneterdPassword() {
	 * driver.findElement(By.id("userPassword")).sendKeys("Milly@123*"); }
	 */
	@When("user clicks on login btn")
	public void userClicksOnLoginBtn() {
		driver.findElement(By.name("login")).click();
	}
	@Then("Login should be successful")
	public void loginShouldBeSuccessful() {
		String text = driver.findElement(By.id("res")).getText();
		System.out.println(text);
		driver.quit();
	}

	/*
	 * @Given("user enter username as abc@com}") public void
	 * userEnterUsernameAsAbc() {
	 * driver.findElement(By.id("userEmail")).sendKeys("abc@com"); }
	 * 
	 * @And("user eneterd password as red") public void userEneterdPasswordAsRed() {
	 * driver.findElement(By.id("userPassword")).sendKeys("red"); }
	 */
	
	@And("user enter username as {string}")
	public void userEnterUsernameAs(String username) {
		driver.findElement(By.id("userEmail")).sendKeys(username); 
	}
	@And("user eneterd password as {string}")
	public void userEneterdPasswordAs(String password) {
		driver.findElement(By.id("userPassword")).sendKeys(password); }
	
	
	@When("user clicks on login btn")
	public void userClicksOnLoginBtsn() {
		driver.findElement(By.name("login")).click();
	}
	@But("Login should be failed")
	public void loginShouldBeFailed() {
		String text2 = driver.findElement(By.xpath("//div[contains(text(),'Incorrect email or password.')]")).getText();
	Assert.assertEquals(text2.trim(), "Incorrect email or password.");
	}
	
}
