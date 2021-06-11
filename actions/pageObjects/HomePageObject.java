package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage {
	WebDriver driver;

// ham khoi tao ( contructor), khi new class nay len thi no se chay dau tien
	// cung ten voi ten class
	
	
	//1 class co the co nhieu contructer ( khac nhau tham so truyen vao , ) truong hop String bike va String moto vẫn là trùng nhau,
	// cần khác kiểu dữ liệu hoặc số lượng tham số ( nếu cùng kiểu dữ liệu)
	// gan driver toan cuc cho cuc bo
// matching driver cho nhieu class
	// chi can new 1 lan driver , nhung class khac gan lai
	
	public HomePageObject(WebDriver driver) {

		this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);

	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, HomePageUI.LOGOUT_LINK);

	}

	public void clickToMyAccountLink() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		
	}

}
