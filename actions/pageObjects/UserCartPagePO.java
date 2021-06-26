package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
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

		return isElementDisplayed(driver, UserCartPageUI.PRODUCT_DETAIL_IN_TABLE, skuID, productName, price,
				quantity, total);
	}

	public UserWistListPagePO clickToWistListLink() {
		waitToElementClickable(driver, UserCartPageUI.WIST_LIST_LINK);
		clickToElement(driver, UserCartPageUI.WIST_LIST_LINK);
		return PageGeneratorManager.getUserWistListPage(driver);
	}

}
