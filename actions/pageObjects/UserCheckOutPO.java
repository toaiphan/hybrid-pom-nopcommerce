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

}
