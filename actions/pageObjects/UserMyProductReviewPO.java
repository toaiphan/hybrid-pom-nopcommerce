package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserMyProductReviewPageUI;

public class UserMyProductReviewPO extends AbstractPage {
	WebDriver driver;

	public UserMyProductReviewPO(WebDriver driver) {
		this.driver = driver;
	}

	public String getReviewTitleText() {
		waitToElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TITLE_TEXT);
		return getElementText(driver, UserMyProductReviewPageUI.REVIEW_TITLE_TEXT);
	}

	public String getReviewText() {
		waitToElementVisible(driver, UserMyProductReviewPageUI.REVIEW_TEXT);
		return getElementText(driver, UserMyProductReviewPageUI.REVIEW_TEXT);
	}


	public Object getProductNameText() {
		waitToElementVisible(driver, UserMyProductReviewPageUI.PRODUCT_NAME_LINK);
		return getElementText(driver, UserMyProductReviewPageUI.PRODUCT_NAME_LINK);
	}

}
