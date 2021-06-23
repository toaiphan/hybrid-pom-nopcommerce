package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminProductPageUI;
import pageUIs.UserHomePageUI;

public class UserHomePO extends AbstractPage {
	WebDriver driver;

// ham khoi tao ( contructor), khi new class nay len thi no se chay dau tien
	// cung ten voi ten class
	
	
	//1 class co the co nhieu contructer ( khac nhau tham so truyen vao , ) truong hop String bike va String moto vẫn là trùng nhau,
	// cần khác kiểu dữ liệu hoặc số lượng tham số ( nếu cùng kiểu dữ liệu)
	// gan driver toan cuc cho cuc bo
// matching driver cho nhieu class
	// chi can new 1 lan driver , nhung class khac gan lai
	
	public UserHomePO(WebDriver driver) {

		this.driver = driver;
	}

	public UserRegisterPO clickToRegisterLink() {
		waitToElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPO clickToLoginLink() {
		waitToElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);


	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGOUT_LINK);

	}

	public UserCustomerInforPO clickToMyAccountLink() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);

		
	}

	public boolean isRegisterLinkUndisplayed() {
		waitToElementInvisible(driver, UserHomePageUI.REGISTER_LINK);
		return isElementUndisplayed(driver, UserHomePageUI.REGISTER_LINK);
	}

	public UserDetailProductPagePO clickToDetailProductByName(String productName) {
		waitToElementClickable(driver, UserHomePageUI.PRODUCT_LINK, productName);
		clickToElement(driver, UserHomePageUI.PRODUCT_LINK, productName);
		return PageGeneratorManager.getUserDetailProductPage(driver);

	}

}
