package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserDetailProductPageUI;
import pageUIs.UserHomePageUI;
import pageUIs.UserProductReviewPageUI;

public class UserDetailProductPagePO extends AbstractPage {
	WebDriver driver;

	public UserDetailProductPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public UserProductReviewPO clickToAddYourReview() {
		waitToElementClickable(driver, UserDetailProductPageUI.ADD_REVIEW_BUTTON);
		clickToElement(driver, UserDetailProductPageUI.ADD_REVIEW_BUTTON);
		return PageGeneratorManager.getUserProductReviewPage(driver);
	}

}
