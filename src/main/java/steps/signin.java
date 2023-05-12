package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.DriverInstance;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class signin extends DriverInstance {
	

	@And("user enters {string} as username")
	public void userEntersAsUsername(String username) {
		driver.findElement(By.id("mat-input-2")).sendKeys(username);
	}

	@And("user enetrs {string} as password")
	public void userEnetrsAsPassword(String password) {
		driver.findElement(By.id("mat-input-3")).sendKeys(password);
	}

	@When("user clicks login button")
	public void userClicksLoginButton() {
		driver.findElement(By.cssSelector("body.app-background:nth-child(2) div.container app-login.ng-star-inserted:nth-child(2) div.docs-example-viewer-wrapper div.docs-example-viewer-body div.full-width mat-card.mat-card.mat-focus-indicator.mat-elevation-z4 mat-card-content.mat-card-content form.ng-dirty.ng-touched.ng-valid mat-card-actions.mat-card-actions:nth-child(3) > button.mat-focus-indicator.mat-raised-button.mat-button-base.mat-primary:nth-child(2)")).click();
	}

	@Then("Signin successfully passed")
	public void signinSuccessfullyPassed() {
		WebElement text = 	driver.findElement(By.cssSelector("input[placeholder=\"Search books or authors\"]"));
		wait.until(ExpectedConditions.visibilityOf(text));
		Assert.assertEquals(text.isDisplayed(), true);

	}

	@Then("signing failed")
	public void signing_failed() {
		String textt =  driver.findElement(By.id("mat-error-0")).getText();
		Assert.assertEquals(textt.trim(), "Username or Password is incorrect.");

	}

}
