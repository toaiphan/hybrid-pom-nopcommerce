package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class PageGeneratorManager {
	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);

	}

	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);

	}

	public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPO(driver);

	}

	public static UserCustomerInforPO getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInforPO(driver);

	}

	public static UserAddressPO getUserAddressesPage(WebDriver driver) {
		return new UserAddressPO(driver);

	}

	public static UserChangePasswordPO getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPO(driver);

	}

	public static UserMyProductReviewPO getUserMyProductReviewPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserMyProductReviewPO(driver);
	}

	public static UserOdersPagePO getUserOdersPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserOdersPagePO(driver);
	}

	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new AdminLoginPO(driver);
	}

	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new AdminDashboardPO(driver);
	}

	public static AdminProductPO getAdminProductPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new AdminProductPO(driver);
	}

	public static UserDetailProductPagePO getUserDetailProductPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserDetailProductPagePO(driver);
	}

	public static UserProductReviewPO getUserProductReviewPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserProductReviewPO(driver);
	}

	public static UserSearchPagePO getUserSearchPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new UserSearchPagePO(driver);
	}

	public static UserWistListPagePO getUserWistListPage(WebDriver driver) {
		return new UserWistListPagePO(driver);
	}

	public static UserCartPagePO getUserCartPage(WebDriver driver) {
		return new UserCartPagePO(driver);
	}

	public static UserCompareProductListPagePO getUserCompareProductListPage(WebDriver driver) {
		return new UserCompareProductListPagePO(driver);
	}
	
	
	public static UserRecentlyViewedProductPagePO getUserRecentlyViewedProductPage(WebDriver driver) {
		return new UserRecentlyViewedProductPagePO(driver);
	}
}
