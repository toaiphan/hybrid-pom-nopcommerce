package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminProductPageUI;
import pageUIs.UserCompareProductListPageUI;
import pageUIs.UserCustomerInforPageUI;
import pageUIs.UserDetailProductPageUI;
import pageUIs.UserHomePageUI;
import pageUIs.UserProductReviewPageUI;
import pageUIs.UserRegisterPageUI;
import pageUIs.UserSearchPageUI;

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

	public UserHomePO clickToHomePage() {
		waitToElementClickable(driver, UserDetailProductPageUI.HOME_PAGE_LINK);
		clickToElement(driver, UserDetailProductPageUI.HOME_PAGE_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public void selectProcesserDropdown(String processer) {
		waitToElementClickable(driver, UserDetailProductPageUI.PROCESSER_DROPDOWN);
		selectItemInDropdown(driver, UserDetailProductPageUI.PROCESSER_DROPDOWN, processer);

	}

	public void selectRamDropdown(String ram) {
		waitToElementClickable(driver, UserDetailProductPageUI.RAM_DROPDOWN);
		selectItemInDropdown(driver, UserDetailProductPageUI.RAM_DROPDOWN, ram);

	}

	public void clickTo400GBRadioButton() {
		waitToElementClickable(driver, UserDetailProductPageUI.HDD_400GB_RADIO_BUTTON);
		clickToElement(driver, UserDetailProductPageUI.HDD_400GB_RADIO_BUTTON);

	}

	public void clickToVistaPremiumRadioButton() {
		waitToElementClickable(driver, UserDetailProductPageUI.OS_VISTA_PRIMIUM_RADIO_BUTTON);
		clickToElement(driver, UserDetailProductPageUI.OS_VISTA_PRIMIUM_RADIO_BUTTON);
	}

	public void checkToMicrosoftOfficeCheckbox() {
		waitToElementClickable(driver, UserDetailProductPageUI.MICROSOFT_CHECKBOX);
		checkToCheckBox(driver, UserDetailProductPageUI.MICROSOFT_CHECKBOX);
	}

	public void checkToAcrobatReadereCheckbox() {
		waitToElementClickable(driver, UserDetailProductPageUI.ACROBAT_READER_CHECKBOX);
		checkToCheckBox(driver, UserDetailProductPageUI.ACROBAT_READER_CHECKBOX);
	}

	public void checkToTotalCommanderCheckbox() {
		waitToElementClickable(driver, UserDetailProductPageUI.TOTAL_COMMANDER_CHECKBOX);
		checkToCheckBox(driver, UserDetailProductPageUI.TOTAL_COMMANDER_CHECKBOX);
	}

	public void clickToAddToCartButton() {
		waitToElementClickable(driver, UserDetailProductPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, UserDetailProductPageUI.ADD_TO_CART_BUTTON);
	}

	public String getAddedSusscessMessage() {
		waitToElementVisible(driver, UserDetailProductPageUI.ADDED_CART_SUCCESS_MESSAGE);
		return getElementText(driver, UserDetailProductPageUI.ADDED_CART_SUCCESS_MESSAGE);
	}

	public UserCartPagePO clickToCartLink() {
		waitToElementClickable(driver, UserDetailProductPageUI.CART_LINK);
		clickToElement(driver, UserDetailProductPageUI.CART_LINK);
		return PageGeneratorManager.getUserCartPage(driver);


	}

	public void clickTo320GBRadioButton() {
		waitToElementClickable(driver, UserDetailProductPageUI.HDD_320GB_RADIO_BUTTON);
		clickToElement(driver, UserDetailProductPageUI.HDD_320GB_RADIO_BUTTON);
		
	}

	public void clickToVistaHomeRadioButton() {
		waitToElementClickable(driver, UserDetailProductPageUI.OS_VISTA_HOME_RADIO_BUTTON);
		clickToElement(driver, UserDetailProductPageUI.OS_VISTA_HOME_RADIO_BUTTON);		
	}

	public void unCheckToAcrobatReadereCheckbox() {
		waitToElementClickable(driver, UserDetailProductPageUI.ACROBAT_READER_CHECKBOX);
		uncheckToCheckBox(driver, UserDetailProductPageUI.ACROBAT_READER_CHECKBOX);		
	}

	public void unCheckToTotalCommanderCheckbox() {
		waitToElementClickable(driver, UserDetailProductPageUI.TOTAL_COMMANDER_CHECKBOX);
		uncheckToCheckBox(driver, UserDetailProductPageUI.TOTAL_COMMANDER_CHECKBOX);
		sleepInSecond(5);
		
	}

	public void inputToProductQuantity(String quantity) {
		waitToElementVisible(driver, UserDetailProductPageUI.PRODUCT_QUANTITY_TEXTBOX);
		sendKeyToElement(driver, UserDetailProductPageUI.PRODUCT_QUANTITY_TEXTBOX, quantity);
		
	}

	public String getPriceTotalText() {
		sleepInSecond(2);
		waitToElementVisible(driver, UserDetailProductPageUI.PRICE_TEXT);
		return getElementText(driver, UserDetailProductPageUI.PRICE_TEXT);
	}


	

}
