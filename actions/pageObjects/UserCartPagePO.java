package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminProductPageUI;
import pageUIs.UserCartPageUI;
import pageUIs.UserWistListPageUI;

public class UserCartPagePO extends AbstractPage {
	WebDriver driver;

	public UserCartPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean areProductDetailDisplayed(String skuID, String productName, String price, String quantity,
			String total) {
		waitToElementVisible(driver, UserCartPageUI.PRODUCT_DETAIL_IN_TABLE, skuID, productName, price, quantity,
				total);

		return isElementDisplayed(driver, UserCartPageUI.PRODUCT_DETAIL_IN_TABLE, skuID, productName, price, quantity,
				total);
	}

	public UserWistListPagePO clickToWistListLink() {
		waitToElementClickable(driver, UserCartPageUI.WIST_LIST_LINK);
		clickToElement(driver, UserCartPageUI.WIST_LIST_LINK);
		return PageGeneratorManager.getUserWistListPage(driver);
	}

	public boolean areProductDetailDisplayed(String productName, String price, String quantity, String total) {
		waitToElementVisible(driver, UserCartPageUI.PRODUCT_DETAIL_IN_TABLE, productName, price, quantity, total);

		return isElementDisplayed(driver, UserCartPageUI.PRODUCT_DETAIL_IN_TABLE, productName, price, quantity, total);
	}

	public UserDetailProductPagePO clickToEditLink() {
		waitToElementClickable(driver, UserCartPageUI.EDIT_CART);
		clickToElement(driver, UserCartPageUI.EDIT_CART);
		return PageGeneratorManager.getUserDetailProductPage(driver);
	}

	public void clickToRemoveButton() {
		waitToElementClickable(driver, UserCartPageUI.REMOVE_BUTTON);
		clickToElement(driver, UserCartPageUI.REMOVE_BUTTON);		
	}

	public String getCartEmptyMessage() {
		waitToElementVisible(driver, UserCartPageUI.NO_DATA_MESSAGE);
		return getElementText(driver, UserCartPageUI.NO_DATA_MESSAGE);
	}

}
