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

	public void clickToAddToWistListButton() {
		waitToElementClickable(driver, UserDetailProductPageUI.ADD_TO_WISTLIST_BUTTON);
		clickToElement(driver, UserDetailProductPageUI.ADD_TO_WISTLIST_BUTTON);
	}

	public String getAddedSuccessMessage() {
		waitToElementVisible(driver, UserDetailProductPageUI.ADDED_SUCCESS_MESSAGE);
		return getElementText(driver, UserDetailProductPageUI.ADDED_SUCCESS_MESSAGE);
	}

	public void clickToCloseMessageButton() {
		waitToElementClickable(driver, UserDetailProductPageUI.CLOSE_ADDED_SUCCESS_MESSAGE_BUTTON);
		clickToElement(driver, UserDetailProductPageUI.CLOSE_ADDED_SUCCESS_MESSAGE_BUTTON);		
		sleepInSecond(2);
	}

	public UserWistListPagePO clickToWistList() {
		waitToElementClickable(driver, UserDetailProductPageUI.WIST_LIST_LINK);
		clickToElement(driver, UserDetailProductPageUI.WIST_LIST_LINK);		
		return PageGeneratorManager.getUserWistListPage(driver);
	}

}
