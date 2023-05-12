package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.DriverInstance;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePage  {
	DriverInstance newdriver;
	
	public HomePage(DriverInstance newdriver) {
		this.newdriver=newdriver;
	}

	@When("user add book to cart")
	public void userAddBookToCart() {
		WebElement addBtn = newdriver.getDriver().findElement(By.cssSelector("button[color=\"primary\"]"));
		WebElement optn = newdriver.getwait().until(ExpectedConditions.visibilityOf(addBtn));
		optn.click();
	}

	
}
