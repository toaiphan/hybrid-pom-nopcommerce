package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserRegisterPageUI;

public class UserRegisterPO extends AbstractPage {
	WebDriver driver;

	// ham khoi tao ( contructor), khi new class nay len thi no se chay dau tien
	// cung ten voi ten class
	// gan driver toan cuc cho cuc bo
	// matching driver cho nhieu class
	// chi can new 1 lan driver , nhung class khac gan lai
	public UserRegisterPO(WebDriver driver) {

		this.driver = driver;
	}

	public void clickToGenderMaleRadioButton() {
		waitToElementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, UserRegisterPageUI.GENDER_MALE_RADIO);

	}

	public void inputToFirstNameTextbox(String firstname) {
		waitToElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstname);
	}

	public void inputToLastNameTextbox(String lastname) {
		waitToElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastname);
	}

	public void selectDayDropdown(String day) {
		waitToElementClickable(driver, UserRegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN, day);

	}

	public void selectMonthDropdown(String month) {
		waitToElementClickable(driver, UserRegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, month);

	}

	public void selectYearDropdown(String year) {
		waitToElementClickable(driver, UserRegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, year);

	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputToCompanyTextbox(String companyName) {
		waitToElementVisible(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, companyName);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitToElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);

	}

	public String getRegisteredSuccessMessage() {
		waitToElementVisible(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MESSAGE);

	}

	public UserHomePO clickToLogoutLink() {
		waitToElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	public String getFirstNameIsRequiredMessage() {
		waitToElementVisible(driver, UserRegisterPageUI.FIRST_NAME_IS_REQUIRED);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_IS_REQUIRED);

	}

	public String getLastNameIsRequiredMessage() {
		waitToElementVisible(driver, UserRegisterPageUI.LAST_NAME_IS_REQUIRED);
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_IS_REQUIRED);
	}

	public String getPasswordIsRequiredMessage() {
		waitToElementVisible(driver, UserRegisterPageUI.PASSWORD_IS_REQUIRED);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_IS_REQUIRED);
	}

	public String getWrongEmailMessage() {
		waitToElementVisible(driver, UserRegisterPageUI.WRONG_EMAIL);
		return getElementText(driver, UserRegisterPageUI.WRONG_EMAIL);
	}

	public String getEmailExistMessage() {
		waitToElementVisible(driver, UserRegisterPageUI.EMAIL_EXIST_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_EXIST_MESSAGE);
	}

	public String getInvalidPassWordMessage() {
		waitToElementVisible(driver, UserRegisterPageUI.INVALID_PASSWORD_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.INVALID_PASSWORD_MESSAGE);
	}

	public String getConfirmPasswordErrorMessage() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}


	public String getUserInformation(String email) {
		// TODO Auto-generated method stub
		return email;
	}

	public String getPasswordInformation(String password) {
		// TODO Auto-generated method stub
		return password;
	}

}
