package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserSearchPageUI;

public class UserSearchPagePO extends AbstractPage {
	WebDriver driver;

	public UserSearchPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitToElementClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}

}
