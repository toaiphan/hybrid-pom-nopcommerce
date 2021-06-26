package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminProductPageUI;
import pageUIs.UserDetailProductPageUI;
import pageUIs.UserHomePageUI;
import pageUIs.UserWistListPageUI;

public class UserWistListPagePO extends AbstractPage {
	WebDriver driver;

	public UserWistListPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean areProductDetailDisplayed(String skuID, String productName, String price, String quantity,
			String total) {
		waitToElementVisible(driver, UserWistListPageUI.PRODUCT_DETAIL_IN_TABLE, skuID, productName, price, quantity,
				total);

		return isElementDisplayed(driver, UserWistListPageUI.PRODUCT_DETAIL_IN_TABLE, skuID, productName, price,
				quantity, total);
	}

	public void clickToShareLink() {
		waitToElementClickable(driver, UserWistListPageUI.SHARE_LINK);
		clickToElement(driver, UserWistListPageUI.SHARE_LINK);

	}

	public boolean isWistListOfTextDisplayed() {
		waitToElementVisible(driver, UserWistListPageUI.WIST_LIST_OF_TEXT);
		return isElementDisplayed(driver, UserWistListPageUI.WIST_LIST_OF_TEXT);
	}

	public boolean areProductDetailInShareLinkDisplayed(String skuID, String productName, String price, String quantity,
			String total) {
		waitToElementVisible(driver, UserWistListPageUI.PRODUCT_DETAIL_IN_TABLE_IN_SHARE_LINK, skuID, productName,
				price, quantity, total);

		return isElementDisplayed(driver, UserWistListPageUI.PRODUCT_DETAIL_IN_TABLE_IN_SHARE_LINK, skuID, productName,
				price, quantity, total);
	}

	public void clickToAddToCartCheckbox() {
		waitToElementClickable(driver, UserWistListPageUI.ADD_TO_CARD_CHECKBOX);
		clickToElement(driver, UserWistListPageUI.ADD_TO_CARD_CHECKBOX);
	}

	public UserCartPagePO clickToAddToCartButton() {
		waitToElementClickable(driver, UserWistListPageUI.ADD_TO_CARD_BUTTON);
		clickToElement(driver, UserWistListPageUI.ADD_TO_CARD_BUTTON);
		return PageGeneratorManager.getUserCartPage(driver);
	}

	public String getEmptyDataMessage() {
		waitToElementVisible(driver, UserWistListPageUI.WIST_LIST_EMPTY_MESSAGE);
		return getElementText(driver, UserWistListPageUI.WIST_LIST_EMPTY_MESSAGE);
	}

	public UserHomePO clickToHomePage() {
		waitToElementClickable(driver, UserWistListPageUI.HOME_PAGE_LINK);
		clickToElement(driver, UserWistListPageUI.HOME_PAGE_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public void clickToRemoveButton() {
		waitToElementClickable(driver, UserWistListPageUI.REMOVE_BUTTON);
		clickToElement(driver, UserWistListPageUI.REMOVE_BUTTON);		
	}

}
