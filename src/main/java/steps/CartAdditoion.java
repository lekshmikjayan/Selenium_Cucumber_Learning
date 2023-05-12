package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.DriverInstance;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CartAdditoion {
	DriverInstance newdriver;
	
	public CartAdditoion(DriverInstance newdriver) {
		this.newdriver = newdriver;
	}
	

	@Given("user login into app with {string} and {string}")
	public void userLoginIntoAppWithAnd(String uname, String pwd) {
		newdriver.getDriver().findElement(By.id("mat-input-2")).sendKeys(uname);
		newdriver.getDriver().findElement(By.id("mat-input-3")).sendKeys(pwd);
	}

	@Given("user search for  {string}")
	public void userSearchFor(String book) {
		newdriver.getDriver().findElement(By.cssSelector("input[placeholder=\"Search books or authors\"]")).sendKeys(book);
		newdriver.getDriver().findElement(By.cssSelector("mat-option[role='option'] span")).click();
	}

	@When("user add book to cart")
	public void userAddBookToCart() {
		WebElement addBtn = newdriver.getDriver().findElement(By.cssSelector("button[color=\"primary\"]"));
		WebElement optn = newdriver.getwait().until(ExpectedConditions.visibilityOf(addBtn));
		optn.click();
	}

	@Then("cart badge updated")
	public void cartBadgeUpdated() {
		String num =	newdriver.getDriver().findElement(By.id("mat-badge-content-0")).getText();
		Assert.assertEquals(Integer.parseInt(num) > 0, true);
		newdriver.getDriver().quit();
	}
}
