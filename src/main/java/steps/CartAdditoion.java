package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.DriverInstance;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CartAdditoion extends DriverInstance{

	

	@Given("user login into app with {string} and {string}")
	public void userLoginIntoAppWithAnd(String uname, String pwd) {
		driver.findElement(By.id("mat-input-2")).sendKeys(uname);
		driver.findElement(By.id("mat-input-3")).sendKeys(pwd);
	}

	@Given("user search for  {string}")
	public void userSearchFor(String book) {
		driver.findElement(By.cssSelector("input[placeholder=\"Search books or authors\"]")).sendKeys(book);
		driver.findElement(By.cssSelector("mat-option[role='option'] span")).click();
	}

	@When("user add book to cart")
	public void userAddBookToCart() {
		WebElement addBtn = driver.findElement(By.cssSelector("button[color=\"primary\"]"));
		WebElement optn = wait.until(ExpectedConditions.visibilityOf(addBtn));
		optn.click();
	}

	@Then("cart badge updated")
	public void cartBadgeUpdated() {
		String num =	driver.findElement(By.id("mat-badge-content-0")).getText();
		Assert.assertEquals(Integer.parseInt(num) > 0, true);
		driver.quit();
	}
}
