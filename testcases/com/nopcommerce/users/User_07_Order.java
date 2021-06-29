package com.nopcommerce.users;

import commons.AbstractTest;
import pageObjects.PageGeneratorManager;
import pageObjects.UserAddressPO;
import pageObjects.UserCartPagePO;
import pageObjects.UserChangePasswordPO;
import pageObjects.UserCheckOutPO;
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

public class User_07_Order extends AbstractTest {
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
	UserCheckOutPO checkOutPage;

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
		detailProductPage = homePage.clickToDetailProductByName("Build your own computer");
	}

	@Test
	public void TC_01_Add_Product_To_Cart() {

		log.info("TC_01_Add_Product_To_Cart - Step 01: Choose Processer ");
		detailProductPage.selectProcesserDropdown("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

		log.info("TC_01_Add_Product_To_Cart - Step 02: Choose RAM ");
		detailProductPage.selectRamDropdown("8GB [+$60.00]");

		log.info("TC_01_Add_Product_To_Cart - Step 03: Choose HDD ");
		detailProductPage.clickTo400GBRadioButton();

		log.info("TC_01_Add_Product_To_Cart - Step 04: Choose OS ");
		detailProductPage.clickToVistaPremiumRadioButton();

		log.info("TC_01_Add_Product_To_Cart - Step 05: Choose SW ");
		detailProductPage.checkToMicrosoftOfficeCheckbox();
		detailProductPage.checkToAcrobatReadereCheckbox();
		detailProductPage.checkToTotalCommanderCheckbox();

		log.info("TC_01_Add_Product_To_Cart - Step 06: Click To Add TO Cart ");
		detailProductPage.clickToAddToCartButton();

		log.info("TC_01_Add_Product_To_Cart - Step 07: Verify added Susscess Message ");
		verifyEquals(detailProductPage.getAddedSusscessMessage(), "The product has been added to your shopping cart");

		log.info("TC_01_Add_Product_To_Cart - Step 08: Click Close Message ");
		detailProductPage.clickToCloseMessageButton();

		log.info("TC_01_Add_Product_To_Cart - Step 09: Click To Cart ");
		cartPage = detailProductPage.clickToCartLink();

		log.info("TC_01_Add_Product_To_Cart - Step 10: Verify Cart ");
		verifyTrue(cartPage.areProductDetailDisplayed("Build your own computer", "$1,500.00", "1", "$1,500.00"));

	}

	@Test
	public void TC_02_Edit_Product_In_Cart() {

		log.info("TC_02_Edit_Product_In_Cart - Step 01: Click To Edit ");
		detailProductPage = cartPage.clickToEditLink();

		log.info("TC_02_Edit_Product_In_Cart - Step 02: Choose Processer ");
		detailProductPage.selectProcesserDropdown("2.2 GHz Intel Pentium Dual-Core E2200");

		log.info("TC_02_Edit_Product_In_Cart - Step 03: Choose RAM ");
		detailProductPage.selectRamDropdown("4GB [+$20.00]");

		log.info("TC_02_Edit_Product_In_Cart - Step 04: Choose HDD ");
		detailProductPage.clickTo320GBRadioButton();

		log.info("TC_02_Edit_Product_In_Cart - Step 05: Choose OS ");
		detailProductPage.clickToVistaHomeRadioButton();

		log.info("TC_02_Edit_Product_In_Cart - Step 06: Choose SW ");
		detailProductPage.checkToMicrosoftOfficeCheckbox();
		detailProductPage.unCheckToAcrobatReadereCheckbox();
		detailProductPage.unCheckToTotalCommanderCheckbox();

		log.info("TC_02_Edit_Product_In_Cart - Step 07: Update Quantity ");
		detailProductPage.inputToProductQuantity("2");

		log.info("TC_02_Edit_Product_In_Cart - Step 08: Verify Price Total ");
		verifyEquals(detailProductPage.getPriceTotalText(), "$1,320.00");

		log.info("TC_02_Edit_Product_In_Cart - Step 09: Click To Add TO Cart ");
		detailProductPage.clickToAddToCartButton();

		log.info("TC_02_Edit_Product_In_Cart - Step 10: Verify added Susscess Message ");
		verifyEquals(detailProductPage.getAddedSusscessMessage(), "The product has been added to your shopping cart");

		log.info("TC_02_Edit_Product_In_Cart - Step 11: Click Close Message ");
		detailProductPage.clickToCloseMessageButton();

		log.info("TC_02_Edit_Product_In_Cart - Step 09: Click To Cart ");
		cartPage = detailProductPage.clickToCartLink();

		log.info("TC_02_Edit_Product_In_Cart - Step 10: Verify Cart ");
		verifyTrue(cartPage.areProductDetailDisplayed("Build your own computer", "$1,320.00", "2", "$2,640.00"));

	}

	@Test
	public void TC_03_Remove_Product_From_Cart() {

		log.info("TC_03_Remove_Product_From_Cart - Step 01: Click To Remove Button ");
		cartPage.clickToRemoveButton();

		log.info("TC_03_Remove_Product_From_Cart - Step 02: Verify Empty Message ");
		verifyEquals(cartPage.getCartEmptyMessage(), "Your Shopping Cart is empty!");

	}

	@Test
	public void TC_04_Update_Cart() {

		log.info("TC_04_Update_Cart - Step 01: Click To Home Page ");
		homePage = cartPage.clickToHomePageLink();

		log.info("TC_04_Update_Cart - Step 02: Click To Detail A Product ");
		detailProductPage = homePage.clickToDetailProductByName("HTC One M8 Android L 5.0 Lollipop");

		log.info("TC_04_Update_Cart - Step 03: Add To Cart ");
		detailProductPage.clickToAddToCartButton();

		log.info("TC_04_Update_Cart - Step 04: Verify added Susscess Message ");
		verifyEquals(detailProductPage.getAddedSusscessMessage(), "The product has been added to your shopping cart");

		log.info("TC_04_Update_Cart - Step 05: Click Close Message ");
		detailProductPage.clickToCloseMessageButton();

		log.info("TC_04_Update_Cart - Step 06: Click To Cart ");
		cartPage = detailProductPage.clickToCartLink();

		log.info("TC_04_Update_Cart - Step 07: Update Quantity ");
		cartPage.inputToProductQuantity("5");

		log.info("TC_04_Update_Cart - Step 08: Click To Update Cart ");
		cartPage.clickToUpdateCart();

		log.info("TC_04_Update_Cart - Step 09: Verify Cart ");
		verifyTrue(
				cartPage.areProductDetailDisplayed("HTC One M8 Android L 5.0 Lollipop", "$245.00", "5", "$1,225.00"));
	}

	@Test
	public void TC_05_Check_Out_By_CheQue() {

		log.info("TC_05_Check_Out_By_CheQue - Step 01: Click To Agree ");
		cartPage.clickToAgreeTermCheckbox();

		log.info("TC_05_Check_Out_By_CheQue - Step 02: Click To Check Out ");
		checkOutPage = cartPage.clickToCheckOutButton();

		log.info("TC_05_Check_Out_By_CheQue - Step 03: Uncheck Ship to the same address ");
		checkOutPage.unCheckShipToSameAddress();

		log.info("TC_05_Check_Out_By_CheQue - Step 04: Select Country ");
		checkOutPage.selectCountryDropdown("United States");

		log.info("TC_05_Check_Out_By_CheQue - Step 05: Select State ");
		checkOutPage.selectStateDropdown("Alabama");

		log.info("TC_05_Check_Out_By_CheQue - Step 06: Input City ");
		checkOutPage.inputToCityTextbox("Ha Noi");

		log.info("TC_05_Check_Out_By_CheQue - Step 07: Input Address1 ");
		checkOutPage.inputToAddress1Textbox("Dinh Thon");
		
		log.info("TC_05_Check_Out_By_CheQue - Step 08: Input Zip ");
		checkOutPage.inputToZipTextbox("550000");

		log.info("TC_05_Check_Out_By_CheQue - Step 09: Input Phone Number ");
		checkOutPage.inputToPhoneNumberTextbox("123456789");


	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (driver != null) {
			// quit trinh duyet
			driver.quit();
		}
	}

}
