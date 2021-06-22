package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserLoginPageUI;
import pageUIs.UserRegisterPageUI;

public class UserLoginPO extends AbstractPage {
	WebDriver driver;

	// ham khoi tao ( contructor), khi new class nay len thi no se chay dau tien
	// cung ten voi ten class
	// gan driver toan cuc cho cuc bo
	// matching driver cho nhieu class
	// chi can new 1 lan driver , nhung class khac gan lai
	public UserLoginPO(WebDriver driver) {

		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX,email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX,password);
	}

	public UserHomePO clickToLoginButton() {
		waitToElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);

		
	}

	public String getEmailErrorMessage() {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getNoAccountFoundMessage() {
		waitToElementVisible(driver, UserLoginPageUI.NO_ACCOUNT_FOUND_MESSAGE);
		return getElementText(driver, UserLoginPageUI.NO_ACCOUNT_FOUND_MESSAGE);
	}

	public String getCredentialIncorrectMessage() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, UserLoginPageUI.CREDENTIALS_PROVIDED_ARE_INCORRECT_MESSAGE);
		return getElementText(driver, UserLoginPageUI.CREDENTIALS_PROVIDED_ARE_INCORRECT_MESSAGE);
	}

}