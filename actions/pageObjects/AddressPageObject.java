package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class AddressPageObject extends AbstractPage {
	WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
