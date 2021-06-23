package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserProductReviewPageUI;

public class UserProductReviewPO extends AbstractPage {
	WebDriver driver;

	public UserProductReviewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void InputToReviewTitleTextbox(String reviewTitle) {
		waitToElementVisible(driver, UserProductReviewPageUI.REVIEW_TITLE_TEXTBOX);
		sendKeyToElement(driver, UserProductReviewPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	public void InputToReviewTextArea(String reviewText) {
		waitToElementVisible(driver, UserProductReviewPageUI.REVIEW_TEXT_TEXTAREA);
		sendKeyToElement(driver, UserProductReviewPageUI.REVIEW_TEXT_TEXTAREA, reviewText);

	}

	public void RatingByNumber(String number) {
		waitToElementClickable(driver, UserProductReviewPageUI.RATING_RADIO_BUTTON, number);
		clickToElement(driver, UserProductReviewPageUI.RATING_RADIO_BUTTON, number);
	}

	public void ClickToSubmitReviewButton() {
		waitToElementClickable(driver, UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public UserCustomerInforPO ClickToMyAccountLink() {
		waitToElementClickable(driver, UserProductReviewPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserProductReviewPageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

}
