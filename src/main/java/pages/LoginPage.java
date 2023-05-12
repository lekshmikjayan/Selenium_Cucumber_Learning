package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.DriverInstance;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage {
DriverInstance newdriver;

public LoginPage(DriverInstance newdriver) {
	this.newdriver=newdriver;
}
	
	@And("user enters {string} as username")
	public LoginPage userEntersAsUsername(String username) {
		newdriver.getDriver().findElement(By.id("mat-input-2")).sendKeys(username);
		return this;
	}

	@And("user enetrs {string} as password")
	public LoginPage userEnetrsAsPassword(String password) {
		newdriver.getDriver().findElement(By.id("mat-input-3")).sendKeys(password);
		return this;
	}

	@When("user clicks login button")
	public HomePage userClicksLoginButton() {
		newdriver.getDriver().findElement(By.cssSelector("body.app-background:nth-child(2) div.container app-login.ng-star-inserted:nth-child(2) div.docs-example-viewer-wrapper div.docs-example-viewer-body div.full-width mat-card.mat-card.mat-focus-indicator.mat-elevation-z4 mat-card-content.mat-card-content form.ng-dirty.ng-touched.ng-valid mat-card-actions.mat-card-actions:nth-child(3) > button.mat-focus-indicator.mat-raised-button.mat-button-base.mat-primary:nth-child(2)")).click();
		return new HomePage(newdriver);
	}

	@Then("Signin successfully passed")
	public HomePage signinSuccessfullyPassed() {
		WebElement text = 	newdriver.getDriver().findElement(By.cssSelector("input[placeholder=\"Search books or authors\"]"));
		newdriver.getwait().until(ExpectedConditions.visibilityOf(text));
		Assert.assertEquals(text.isDisplayed(), true);
return new HomePage(newdriver);
	}

	@Then("signing failed")
	public LoginPage signing_failed() {
		String textt =  newdriver.getDriver().findElement(By.id("mat-error-0")).getText();
		Assert.assertEquals(textt.trim(), "Username or Password is incorrect.");
return this;
	}
	@Given("user login into app with {string} and {string}")
	public void userLoginIntoAppWithAnd(String uname, String pwd) {
		 new HeaderPage(newdriver).userEnterLoginLink();
		 this.userEntersAsUsername(uname);
		 this.userEnetrsAsPassword(pwd);
		 this.userClicksLoginButton();
		 this.signinSuccessfullyPassed();
		 this.signing_failed();
		
	}
}
