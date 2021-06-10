package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.CustomerInforPageUI;

public class CustomerInforPageObject extends AbstractPage {
	WebDriver driver;

	// ham khoi tao ( contructor), khi new class nay len thi no se chay dau tien
	// cung ten voi ten class
	// gan driver toan cuc cho cuc bo
	// matching driver cho nhieu class
	// chi can new 1 lan driver , nhung class khac gan lai
	public CustomerInforPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisible(driver, CustomerInforPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, CustomerInforPageUI.GENDER_MALE_RADIO);
	}

	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitToElementVisible(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInforPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getSelectedTextInDayDropdown() {
		waitToElementVisible(driver, CustomerInforPageUI.DAY_DROPDOWN);
		return getFirstSelectedItemInDropdown(driver, CustomerInforPageUI.DAY_DROPDOWN);
	}

	public String getSelectedTextInMonthDropdown() {
		waitToElementVisible(driver, CustomerInforPageUI.MONTH_DROPDOWN);
		return getFirstSelectedItemInDropdown(driver, CustomerInforPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedTextInYearDropdown() {
		waitToElementVisible(driver, CustomerInforPageUI.YEAR_DROPDOWN);
		return getFirstSelectedItemInDropdown(driver, CustomerInforPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextboxValue() {
		waitToElementVisible(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerInforPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyTextboxValue() {
		waitToElementVisible(driver, CustomerInforPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, CustomerInforPageUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isNewLeterCheckboxSelected() {
		waitToElementVisible(driver, CustomerInforPageUI.NEWSLETTER_TEXTBOX);
		return isElementSelected(driver, CustomerInforPageUI.NEWSLETTER_TEXTBOX);
	}



}