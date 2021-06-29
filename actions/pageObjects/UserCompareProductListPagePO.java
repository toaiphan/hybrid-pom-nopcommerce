package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminProductPageUI;
import pageUIs.UserCompareProductListPageUI;
import pageUIs.UserHomePageUI;
import pageUIs.UserWistListPageUI;

public class UserCompareProductListPagePO extends AbstractPage {
	WebDriver driver;

	public UserCompareProductListPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean areProductDisplayed(String productName1, String productName2) {
		waitToElementVisible(driver, UserCompareProductListPageUI.TWO_PRODUCT_NAME_DYNAMIC_TEXT, productName1,
				productName2);

		return isElementDisplayed(driver, UserCompareProductListPageUI.TWO_PRODUCT_NAME_DYNAMIC_TEXT, productName1,
				productName2);
	}

	public void clickToClearList() {
		waitToElementClickable(driver, UserCompareProductListPageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, UserCompareProductListPageUI.CLEAR_LIST_BUTTON);

	}

	public String getNoDataMessage() {
		waitToElementVisible(driver, UserCompareProductListPageUI.NO_DATA);
		return getElementText(driver, UserCompareProductListPageUI.NO_DATA);
	}

	public UserHomePO clickToHomePage() {
		waitToElementClickable(driver, UserCompareProductListPageUI.HOME_PAGE_LINK);
		clickToElement(driver, UserCompareProductListPageUI.HOME_PAGE_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}


}
