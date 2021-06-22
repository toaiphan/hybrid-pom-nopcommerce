package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserChangePasswordPageUI;

public class UserChangePasswordPO extends AbstractPage {
	WebDriver driver;

	public UserChangePasswordPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToOldPasswordTextbox(String oldPassword) {
		waitToElementVisible(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);
	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitToElementVisible(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);

	}

	public void inputToConfirmPasswordTextbox(String newPassword) {
		waitToElementVisible(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD);
		sendKeyToElement(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD, newPassword);
	}

	public void clickToChangePasswordButton() {
		waitToElementClickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public void clickToClosePopupButton() {
		waitToElementClickable(driver, UserChangePasswordPageUI.CLOSE_SUCCESS_POPUP_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.CLOSE_SUCCESS_POPUP_BUTTON);
		sleepInSecond(2);
		
	}

	public UserHomePO clickToLogoutButton() {
		waitToElementClickable(driver, UserChangePasswordPageUI.LOG_OUT_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.LOG_OUT_BUTTON);	
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
