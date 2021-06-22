package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCustomerInforPageUI;

public class UserCustomerInforPO extends AbstractPage {
	WebDriver driver;

	// ham khoi tao ( contructor), khi new class nay len thi no se chay dau tien
	// cung ten voi ten class
	// gan driver toan cuc cho cuc bo
	// matching driver cho nhieu class
	// chi can new 1 lan driver , nhung class khac gan lai
	public UserCustomerInforPO(WebDriver driver) {

		this.driver = driver;
	}

	public boolean isGenderMaleRadioButtonSelected() {
		waitToElementVisible(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
	}

	public String getFirstNameTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getSelectedTextInDayDropdown() {
		waitToElementVisible(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
		return getFirstSelectedItemInDropdown(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
	}

	public String getSelectedTextInMonthDropdown() {
		waitToElementVisible(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
		return getFirstSelectedItemInDropdown(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedTextInYearDropdown() {
		waitToElementVisible(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
		return getFirstSelectedItemInDropdown(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyTextboxValue() {
		waitToElementVisible(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isNewLeterCheckboxSelected() {
		waitToElementVisible(driver, UserCustomerInforPageUI.NEWSLETTER_TEXTBOX);
		return isElementSelected(driver, UserCustomerInforPageUI.NEWSLETTER_TEXTBOX);
	}

	public void clickToFamaleRadioButton() {
		waitToElementClickable(driver, UserCustomerInforPageUI.GENDER_FAMALE_RADIO);
		clickToElement(driver, UserCustomerInforPageUI.GENDER_FAMALE_RADIO);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitToElementVisible(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, firstName);

	}

	public void inputToLastNameTextbox(String lastName) {
		waitToElementVisible(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX, lastName);

	}

	public void selectDayDropdown(String day) {
		waitToElementClickable(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, UserCustomerInforPageUI.DAY_DROPDOWN, day);
	}

	public void selectMonthDropdown(String month) {
		waitToElementClickable(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserCustomerInforPageUI.MONTH_DROPDOWN, month);
	}

	public void selectYearDropdown(String year) {
		waitToElementClickable(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserCustomerInforPageUI.YEAR_DROPDOWN, year);
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, email);
	}

	public void clickToSaveButton() {
		waitToElementClickable(driver, UserCustomerInforPageUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInforPageUI.SAVE_BUTTON);

	}

	public void inputToCompanyTextbox(String companyName) {
		waitToElementVisible(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX, companyName);
	}

	public boolean isGenderFamaleRadioButtonSelected() {
		waitToElementVisible(driver, UserCustomerInforPageUI.GENDER_FAMALE_RADIO);
		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_FAMALE_RADIO);
	}

}