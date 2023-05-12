package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.DriverInstance;
import base.PageContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HeaderPage {
	DriverInstance newdriver;

	public HeaderPage(DriverInstance newdriver) {
		this.newdriver=newdriver;
	}

	public void userEnterLoginLink() {
		newdriver.getDriver().findElement(By.xpath("//body/app-root[1]/app-nav-bar[1]/mat-toolbar[1]/mat-toolbar-row[1]/div[3]/button[2]/span[1]")).click();
	}

	@Given("user search for  {string}")
	public void userSearchFor(String book) {
		newdriver.getDriver().findElement(By.cssSelector("input[placeholder=\"Search books or authors\"]")).sendKeys(book);
		newdriver.getDriver().findElement(By.cssSelector("mat-option[role='option'] span")).click();
	}

	@Then("cart badge updated")
	public void cartBadgeUpdated() {
		String num =	newdriver.getDriver().findElement(By.id("mat-badge-content-0")).getText();
		Assert.assertEquals(Integer.parseInt(num) > 0, true);
		newdriver.getDriver().quit();
	}
}
