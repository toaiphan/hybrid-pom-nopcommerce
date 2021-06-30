package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCartPageUI;
import pageUIs.UserCheckOutPageUI;
import pageUIs.UserRegisterPageUI;

public class UserCheckOutPO extends AbstractPage {
	WebDriver driver;

	public UserCheckOutPO(WebDriver driver) {
		this.driver = driver;
	}

	public void unCheckShipToSameAddress() {
		waitToElementClickable(driver, UserCheckOutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
		uncheckToCheckBox(driver, UserCheckOutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
	}

	public void selectCountryDropdown(String country) {
		waitToElementClickable(driver, UserCheckOutPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, UserCheckOutPageUI.COUNTRY_DROPDOWN, country);
	}

	public void selectStateDropdown(String state) {
		waitToElementClickable(driver, UserCheckOutPageUI.STATE_DROPDOWN);
		selectItemInDropdown(driver, UserCheckOutPageUI.STATE_DROPDOWN, state);

	}

	public void inputToCityTextbox(String city) {
		waitToElementVisible(driver, UserCheckOutPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, UserCheckOutPageUI.CITY_TEXTBOX, city);

	}

	public void inputToAddress1Textbox(String address) {
		waitToElementVisible(driver, UserCheckOutPageUI.ADDRESS1_TEXTBOX);
		sendKeyToElement(driver, UserCheckOutPageUI.ADDRESS1_TEXTBOX, address);

	}

	public void inputToZipTextbox(String zip) {
		waitToElementVisible(driver, UserCheckOutPageUI.ZIPCODE_TEXTBOX);
		sendKeyToElement(driver, UserCheckOutPageUI.ZIPCODE_TEXTBOX, zip);

	}

	public void inputToPhoneNumberTextbox(String phone) {
		waitToElementVisible(driver, UserCheckOutPageUI.PHONE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, UserCheckOutPageUI.PHONE_NUMBER_TEXTBOX, phone);

	}

	public void clickToBillingContinueButton() {
		waitToElementClickable(driver, UserCheckOutPageUI.BILLING_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckOutPageUI.BILLING_CONTINUE_BUTTON);
	}

	public void selectAddressDropdown(String address) {
		waitToElementClickable(driver, UserCheckOutPageUI.SHIPPING_ADDRESS_DROPDOWN);
		selectItemInDropdown(driver, UserCheckOutPageUI.SHIPPING_ADDRESS_DROPDOWN, address);
	}

	public void clickToAddressContinueButton() {
		waitToElementClickable(driver, UserCheckOutPageUI.ADDRESS_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckOutPageUI.ADDRESS_CONTINUE_BUTTON);
	}

	public void clickToShipingContinueButton() {
		waitToElementClickable(driver, UserCheckOutPageUI.SHIP_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckOutPageUI.SHIP_CONTINUE_BUTTON);
	}

	public void clickToPaymentContinueButton() {
		waitToElementClickable(driver, UserCheckOutPageUI.PAYMENT_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckOutPageUI.PAYMENT_CONTINUE_BUTTON);
	}

	public String getPaymentInformationText() {
		waitToElementVisible(driver, UserCheckOutPageUI.PAYMENT_INFORMATION_TEXT);
		return getElementText(driver, UserCheckOutPageUI.PAYMENT_INFORMATION_TEXT);
	}

	public void clickToConfirmContinueButton() {
		waitToElementClickable(driver, UserCheckOutPageUI.CONFIRM_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckOutPageUI.CONFIRM_CONTINUE_BUTTON);
	}

	public boolean areProductDetailDisplayed(String productName, String price, String quantity, String total) {
		waitToElementVisible(driver, UserCheckOutPageUI.PRODUCT_DETAIL_IN_TABLE, productName, price, quantity, total);

		return isElementDisplayed(driver, UserCheckOutPageUI.PRODUCT_DETAIL_IN_TABLE, productName, price, quantity,
				total);
	}

	public String getBillingEmailText() {
		waitToElementVisible(driver, UserCheckOutPageUI.BILLING_EMAIL_TEXT);
		return getElementText(driver, UserCheckOutPageUI.BILLING_EMAIL_TEXT);
	}

	public String getShippingPhoneText() {
		waitToElementVisible(driver, UserCheckOutPageUI.SHIPPING_PHONE_TEXT);
		return getElementText(driver, UserCheckOutPageUI.SHIPPING_PHONE_TEXT);
	}

	public String getPaymentMethodText() {
		waitToElementVisible(driver, UserCheckOutPageUI.PAYMENT_METHOD_TEXT);
		return getElementText(driver, UserCheckOutPageUI.PAYMENT_METHOD_TEXT);
	}

	public String getShippingMethodText() {
		waitToElementVisible(driver, UserCheckOutPageUI.SHIPPING_METHOD_TEXT);
		return getElementText(driver, UserCheckOutPageUI.SHIPPING_METHOD_TEXT);
	}

	public String getShippingTotalText() {
		waitToElementVisible(driver, UserCheckOutPageUI.TOTAL_TEXT);
		return getElementText(driver, UserCheckOutPageUI.TOTAL_TEXT);
	}

	public void clickToConfirmButton() {
		waitToElementClickable(driver, UserCheckOutPageUI.CONFIRM_BUTTON);
		clickToElement(driver, UserCheckOutPageUI.CONFIRM_BUTTON);
	}

	public String getSuccessMessage() {
		waitToElementVisible(driver, UserCheckOutPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, UserCheckOutPageUI.SUCCESS_MESSAGE);
	}

	public boolean isOrderNumberDisplayed() {
		waitToElementVisible(driver, UserCheckOutPageUI.ORDER_NUMBER_TEXT);

		return isElementDisplayed(driver, UserCheckOutPageUI.ORDER_NUMBER_TEXT);
	}
}
