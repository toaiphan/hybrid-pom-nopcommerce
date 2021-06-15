package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class PageGeneratorManager {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);

	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);

	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);

	}

	public static CustomerInforPageObject getCustomerInfoPage(WebDriver driver) {
		return new CustomerInforPageObject(driver);

	}
	
	public static AddressPageObject getAddressesPage(WebDriver driver) {
		return new AddressPageObject(driver);

	}

	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new MyProductReviewPageObject(driver);
	}

	public static OdersPagePageObject getOdersPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new OdersPagePageObject(driver);
	}

}
