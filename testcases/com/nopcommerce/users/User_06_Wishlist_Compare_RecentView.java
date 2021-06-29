package com.nopcommerce.users;

import commons.AbstractTest;
import pageObjects.PageGeneratorManager;
import pageObjects.UserAddressPO;
import pageObjects.UserCartPagePO;
import pageObjects.UserChangePasswordPO;
import pageObjects.UserCompareProductListPagePO;
import pageObjects.UserCustomerInforPO;
import pageObjects.UserDetailProductPagePO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserOdersPagePO;
import pageObjects.UserProductReviewPO;
import pageObjects.UserRecentlyViewedProductPagePO;
import pageObjects.UserRegisterPO;
import pageObjects.UserSearchPagePO;
import pageObjects.UserWistListPagePO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_06_Wishlist_Compare_RecentView extends AbstractTest {
	WebDriver driver;
	UserHomePO homePage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInfoPage;
	UserRegisterPO registerPage;
	UserAddressPO addressPage;
	UserMyProductReviewPO myProductReviewPage;
	UserOdersPagePO odersPagePage;
	UserChangePasswordPO changePasswordPage;
	UserDetailProductPagePO detailProductPage;
	UserProductReviewPO productReviewPage;
	UserSearchPagePO searchPage;
	UserWistListPagePO wistListPage;
	UserCartPagePO cartPage;
	UserCompareProductListPagePO compageProductListPage;
	UserRecentlyViewedProductPagePO recentlyViewedProductPage;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		log.info("Pre-condition - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 02: Click To Login Link");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-condition - Step 03: Input Username,Password");
		loginPage.inputToEmailTextbox(Common_01_RegisterToSystem.USERNAME);
		loginPage.inputToPasswordTextbox(Common_01_RegisterToSystem.PASSWORD);

		log.info("Pre-condition - Step 04: Click To Login Button");
		homePage = loginPage.clickToLoginButton();

		log.info("Pre-condition - Step 05: Open A Product");
		detailProductPage = homePage.clickToDetailProductByName("Apple MacBook Pro 13-inch");
	}

	@Test
	public void TC_01_Add_To_Wistlist() {

		log.info("TC_01_Add_To_Wistlist - Step 01: Click Add To WistList ");
		detailProductPage.clickToAddToWistListButton();

		log.info("TC_01_Add_To_Wistlist - Step 02: Verify Added Success Message Displayed ");
		verifyEquals(detailProductPage.getAddedSuccessMessage(), "The product has been added to your wishlist");

		log.info("TC_01_Add_To_Wistlist - Step 03: Close Added Success Message  ");
		detailProductPage.clickToCloseMessageButton();

		log.info("TC_01_Add_To_Wistlist - Step 04: Click To Wistlist ");
		wistListPage = detailProductPage.clickToWistList();

		log.info("TC_01_Add_To_Wistlist - Step 05: Verify Product Added");
		verifyTrue(wistListPage.areProductDetailDisplayed("AP_MBP_13", "Apple MacBook Pro 13-inch", "$1,800.00", "2",
				"$3,600.00"));

		log.info("TC_01_Add_To_Wistlist - Step 06: Click Share Link");
		wistListPage.clickToShareLink();

		log.info("TC_01_Add_To_Wistlist - Step 07: Verify Share Link Displayed");
		verifyTrue(wistListPage.isWistListOfTextDisplayed());

		log.info("TC_01_Add_To_Wistlist - Step 08: Verify Product Added In Share Link");
		verifyTrue(wistListPage.areProductDetailInShareLinkDisplayed("AP_MBP_13", "Apple MacBook Pro 13-inch",
				"$1,800.00", "2", "$3,600.00"));

	}

	@Test
	public void TC_02_Add_Product_To_Cart_From_WistList_Page() {
		log.info("TC_02_Add_Product_To_Cart_From_WistList_Page - Step 01: Back To Wist List Page ");

		wistListPage.backToPage(driver);

		log.info("TC_02_Add_Product_To_Cart_From_WistList_Page - Step 02: Click To Add To Cart Checkbox ");
		wistListPage.clickToAddToCartCheckbox();

		log.info("TC_02_Add_Product_To_Cart_From_WistList_Page - Step 03: Click To Add To Cart Button ");
		cartPage = wistListPage.clickToAddToCartButton();

		log.info("TC_02_Add_Product_To_Cart_From_WistList_Page - Step 04: Verify Information In Cart ");
		verifyTrue(cartPage.areProductDetailDisplayed("AP_MBP_13", "Apple MacBook Pro 13-inch", "$1,800.00", "2",
				"$3,600.00"));

		log.info("TC_02_Add_Product_To_Cart_From_WistList_Page - Step 05: Click To Wistlist ");
		wistListPage = cartPage.clickToWistListLink();

		log.info("TC_02_Add_Product_To_Cart_From_WistList_Page - Step 06: Verify WistList Empty ");
		verifyEquals(wistListPage.getEmptyDataMessage(), "The wishlist is empty!");

	}

	@Test
	public void TC_03_Remove_Product_In_WistList_Page() {
		log.info("TC_03_Remove_Product_In_WistList_Page - Step 01: Click To Home Page ");
		homePage = wistListPage.clickToHomePage();

		log.info("TC_03_Remove_Product_In_WistList_Page - Step 02: Click To A Product ");
		detailProductPage = homePage.clickToDetailProductByName("HTC One M8 Android L 5.0 Lollipop");

		log.info("TC_03_Remove_Product_In_WistList_Page - Step 03: Click To Add To Wist List ");
		detailProductPage.clickToAddToWistListButton();

		log.info("TC_03_Remove_Product_In_WistList_Page - Step 04: Verify Added Success Message Displayed ");
		verifyEquals(detailProductPage.getAddedSuccessMessage(), "The product has been added to your wishlist");

		log.info("TC_03_Remove_Product_In_WistList_Page - Step 05: Close Added Success Message  ");
		detailProductPage.clickToCloseMessageButton();

		log.info("TC_03_Remove_Product_In_WistList_Page - Step 06: Click To Wistlist ");
		wistListPage = detailProductPage.clickToWistList();

		log.info("TC_03_Remove_Product_In_WistList_Page - Step 07: Click To Remove ");
		wistListPage.clickToRemoveButton();

		log.info("TC_03_Remove_Product_In_WistList_Page - Step 08: Verify WistList Empty ");
		verifyEquals(wistListPage.getEmptyDataMessage(), "The wishlist is empty!");

	}

	@Test
	public void TC_04_Add_Product_To_Compare() {
		log.info("TC_04_Add_Product_To_Compare - Step 01: Click To HomePage");
		homePage = wistListPage.clickToHomePage();

		log.info("TC_04_Add_Product_To_Compare - Step 02: Click Add To Compare List 1 product");
		homePage.clickAddToCompareListByName("Build your own computer");

		log.info("TC_04_Add_Product_To_Compare - Step 03: Verify Success Message");
		verifyEquals(homePage.getAddedToCompareSusscessMessage(),
				"The product has been added to your product comparison");

		log.info("TC_04_Add_Product_To_Compare - Step 04: Click Add To Compare List 1 product");
		homePage.clickAddToCompareListByName("Apple MacBook Pro 13-inch");

		log.info("TC_04_Add_Product_To_Compare - Step 05: Verify Success Message");
		verifyEquals(homePage.getAddedToCompareSusscessMessage(),
				"The product has been added to your product comparison");

		log.info("TC_04_Add_Product_To_Compare - Step 06: Click To Compare Product List In Footer");
		homePage.clickToLinkInFooterbyName(driver, "Compare products list");
		compageProductListPage = PageGeneratorManager.getUserCompareProductListPage(driver);

		log.info("TC_04_Add_Product_To_Compare - Step 07: Verify displayed");
		verifyTrue(compageProductListPage.areProductDisplayed("Build your own computer", "Apple MacBook Pro 13-inch"));

		log.info("TC_04_Add_Product_To_Compare - Step 08: Click To Clear List");
		compageProductListPage.clickToClearList();

		log.info("TC_04_Add_Product_To_Compare - Step 09: Verify Compare List Empty");
		verifyEquals(compageProductListPage.getNoDataMessage(), "You have no items to compare.");

	}

	@Test
	public void TC_05_Recently_Viewed_Product() {
		log.info("TC_05_Recently_Viewed_Product - Step 01: Click To HomePage");
		homePage = compageProductListPage.clickToHomePage();

		log.info("TC_05_Recently_Viewed_Product - Step 02: Click 1st product");
		detailProductPage = homePage.clickToDetailProductByName("Build your own computer");

//		log.info("TC_05_Recently_Viewed_Product - Step 03: Click To HomePage");
//		homePage = detailProductPage.clickToHomePage();

//		log.info("TC_05_Recently_Viewed_Product - Step 04: Click 2nd product");
//		detailProductPage = homePage.clickToDetailProductByName("Apple MacBook Pro 13-inch");

		log.info("TC_05_Recently_Viewed_Product - Step 05: Click To HomePage");
		homePage = detailProductPage.clickToHomePage();

		log.info("TC_05_Recently_Viewed_Product - Step 06: Click 3rd product");
		detailProductPage = homePage.clickToDetailProductByName("HTC One M8 Android L 5.0 Lollipop");

		log.info("TC_05_Recently_Viewed_Product - Step 07: Click To HomePage");
		homePage = detailProductPage.clickToHomePage();

		log.info("TC_05_Recently_Viewed_Product - Step 08: Click 4th product");
		detailProductPage = homePage.clickToDetailProductByName("$25 Virtual Gift Card");

		log.info("TC_05_Recently_Viewed_Product - Step 09: Click To HomePage");
		homePage = detailProductPage.clickToHomePage();

		log.info("TC_05_Recently_Viewed_Product - Step 10: Click To Recently Viewed Product");
		homePage.clickToLinkInFooterbyName(driver, "Recently viewed products");
		recentlyViewedProductPage = PageGeneratorManager.getUserRecentlyViewedProductPage(driver);

		log.info("TC_05_Recently_Viewed_Product - Step 11: Verify Product Displayed");
		verifyTrue(recentlyViewedProductPage.areProductsDisplayed("$25 Virtual Gift Card","Build your own computer","HTC One M8 Android L 5.0 Lollipop"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (driver != null) {
			// quit trinh duyet
			driver.quit();
		}
	}

}
