package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage {
	WebDriver driver;

// ham khoi tao ( contructor), khi new class nay len thi no se chay dau tien
	// cung ten voi ten class
	// gan driver toan cuc cho cuc bo
// matching driver cho nhieu class
	// chi can new 1 lan driver , nhung class khac gan lai
	public HomePageObject(WebDriver driver) {

		this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

}
