package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	// ham khoi tao ( contructor), khi new class nay len thi no se chay dau tien
	// cung ten voi ten class
	// gan driver toan cuc cho cuc bo
	// matching driver cho nhieu class
	// chi can new 1 lan driver , nhung class khac gan lai
	public RegisterPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public void clickToGenderMaleRadioButton() {
		waitToElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);

	}

	public void inputToFirstNameTextbox(String firstname) {
		waitToElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstname);
	}

	public void inputToLastNameTextbox(String lastname) {
		waitToElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastname);
	}

	public void selectDayDropdown(String day) {
		waitToElementClickable(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.DAY_DROPDOWN, day);

	}

	public void selectMonthDropdown(String month) {
		waitToElementClickable(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, month);

	}

	public void selectYearDropdown(String year) {
		waitToElementClickable(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);

	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputToCompanyTextbox(String companyName) {
		waitToElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, companyName);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitToElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public String getRegisteredSuccessMessage() {
		waitToElementVisible(driver, RegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTERED_SUCCESS_MESSAGE);

	}

	public HomePageObject clickToLogoutLink() {
		waitToElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
		
	}

}
