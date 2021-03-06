package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserAddressPageUI;

public class UserAddressPO extends AbstractPage {
	WebDriver driver;

	public UserAddressPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstNameTextbox(String firstname) {
		waitToElementVisible(driver, UserAddressPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.FIRSTNAME_TEXTBOX, firstname);
	}

	public void inputToLastNameTextbox(String lastname) {
		waitToElementVisible(driver, UserAddressPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.LASTNAME_TEXTBOX, lastname);

	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserAddressPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToCompanyTextbox(String companyName) {
		waitToElementVisible(driver, UserAddressPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.COMPANY_TEXTBOX, companyName);

	}

	public void selectCountryDropdown(String country) {
		waitToElementClickable(driver, UserAddressPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, UserAddressPageUI.COUNTRY_DROPDOWN, country);
	}

	public void selectStateDropdown(String state) {
		waitToElementClickable(driver, UserAddressPageUI.STATE_DROPDOWN);
		selectItemInDropdown(driver, UserAddressPageUI.STATE_DROPDOWN, state);
	}

	public void inputToCityTextbox(String city) {
		waitToElementVisible(driver, UserAddressPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.CITY_TEXTBOX, city);

	}

	public void inputToAddress1Textbox(String address1) {
		waitToElementVisible(driver, UserAddressPageUI.ADDRESS1_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.ADDRESS1_TEXTBOX, address1);
	}

	public void inputToAddress2Textbox(String address2) {
		waitToElementVisible(driver, UserAddressPageUI.ADDRESS2_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.ADDRESS2_TEXTBOX, address2);

	}

	public void inputToZipTextbox(String zip) {
		waitToElementVisible(driver, UserAddressPageUI.ZIP_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.ZIP_TEXTBOX, zip);
	}

	public void inputToPhoneTextbox(String phone) {
		waitToElementVisible(driver, UserAddressPageUI.PHONE_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.PHONE_TEXTBOX, phone);
	}

	public void inputToFaxTextbox(String fax) {
		waitToElementVisible(driver, UserAddressPageUI.FAX_TEXTBOX);
		sendKeyToElement(driver, UserAddressPageUI.FAX_TEXTBOX, fax);

	}

	public void clickToSaveButton() {
		waitToElementClickable(driver, UserAddressPageUI.SAVE_BUTTON);
		clickToElement(driver, UserAddressPageUI.SAVE_BUTTON);
	}

	public void clickToAddNewButton() {
		waitToElementClickable(driver, UserAddressPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, UserAddressPageUI.ADD_NEW_BUTTON);
	}

	public String getNameText() {
		waitToElementVisible(driver, UserAddressPageUI.FIRST_LASTNAME_TEXT);
		return getElementText(driver, UserAddressPageUI.FIRST_LASTNAME_TEXT);
	}

	public String getEmailText() {
		waitToElementVisible(driver, UserAddressPageUI.EMAIL_TEXT);
		return getElementText(driver, UserAddressPageUI.EMAIL_TEXT);
	}

	public String getPhoneText() {
		waitToElementVisible(driver, UserAddressPageUI.PHONE_TEXT);
		return getElementText(driver, UserAddressPageUI.PHONE_TEXT);
	}

	public String getFaxText() {
		waitToElementVisible(driver, UserAddressPageUI.FAX_TEXT);
		return getElementText(driver, UserAddressPageUI.FAX_TEXT);
	}

	public String getCompanyText() {
		waitToElementVisible(driver, UserAddressPageUI.COMPANY_TEXT);
		return getElementText(driver, UserAddressPageUI.COMPANY_TEXT);
	}

	public String getAddress1Text() {
		waitToElementVisible(driver, UserAddressPageUI.ADDRESS1_TEXT);
		return getElementText(driver, UserAddressPageUI.ADDRESS1_TEXT);
	}

	public String getAddress2Text() {
		waitToElementVisible(driver, UserAddressPageUI.ADDRESS2_TEXT);
		return getElementText(driver, UserAddressPageUI.ADDRESS2_TEXT);
	}

	public String getCityStateZipText() {
		waitToElementVisible(driver, UserAddressPageUI.CITY_STATE_ZIP_TEXT);
		return getElementText(driver, UserAddressPageUI.CITY_STATE_ZIP_TEXT);
	}

	public String getCountryText() {
		waitToElementVisible(driver, UserAddressPageUI.COUNTRY_TEXT);
		return getElementText(driver, UserAddressPageUI.COUNTRY_TEXT);
	}

}
