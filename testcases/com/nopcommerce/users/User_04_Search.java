package com.nopcommerce.users;

import commons.AbstractTest;
import pageObjects.PageGeneratorManager;
import pageObjects.UserAddressPO;
import pageObjects.UserChangePasswordPO;
import pageObjects.UserCustomerInforPO;
import pageObjects.UserDetailProductPagePO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserOdersPagePO;
import pageObjects.UserProductReviewPO;
import pageObjects.UserRegisterPO;
import pageObjects.UserSearchPagePO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class User_04_Search extends AbstractTest {
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
	Select select;
	String dataNotExist, relativeProduct, absoluteProduct, appleProductName, category,hpManufacturer,appleManufacturer;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		dataNotExist = "Macbook Pro 2050";
		relativeProduct = "Lenovo";
		absoluteProduct = "Lenovo Thinkpad X1 Carbon Laptop";
		appleProductName = "Apple macbook pro";
		category = "Computers";
		hpManufacturer="HP";
		appleManufacturer="Apple";

		log.info("Pre-condition - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 02: Click To Login Link");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-condition - Step 03: Input Username,Password");
		loginPage.inputToEmailTextbox(Common_01_RegisterToSystem.USERNAME);
		loginPage.inputToPasswordTextbox(Common_01_RegisterToSystem.PASSWORD);

		log.info("Pre-condition - Step 04: Click To Login Button");
		homePage = loginPage.clickToLoginButton();

		log.info("Pre-condition - Step 05: Click To Search Link In Footer");
		searchPage = homePage.clickToLinkInFooterbyName("Search");
	}

	@Test
	public void TC_01_Search_With_Empty_Data() {
		log.info("TC_01_Search_With_Empty_Data - Step 01: Click To Search Button ");
		searchPage.clickToSearchButton();

		log.info("TC_01_Search_With_Empty_Data - Step 02: Verify Error ");
		verifyEquals(searchPage.getEmptyErrorMessageText(), "Search term minimum length is 3 characters");

	}

	@Test
	public void TC_02_Search_With_Data_Not_Exist() {

		log.info("TC_02_Search_With_Data_Not_Exist - Step 01: Input Data Not Exist ");
		searchPage.inputToSearchTextbox(dataNotExist);

		log.info("TC_02_Search_With_Data_Not_Exist - Step 02: Click To Search Button ");
		searchPage.clickToSearchButton();

		log.info("TC_02_Search_With_Data_Not_Exist - Step 03: Verify Error ");
		verifyEquals(searchPage.getNoResultMessageText(), "No products were found that matched your criteria.");

	}

	@Test
	public void TC_03_Relative_Search_Product() {

		log.info("TC_03_Relative_Search_Product - Step 01: Input Relative Product ");
		searchPage.inputToSearchTextbox(relativeProduct);

		log.info("TC_03_Relative_Search_Product - Step 02: Click To Search Button ");
		searchPage.clickToSearchButton();

		log.info("TC_03_Relative_Search_Product - Step 03: Verify 2 Products Appear ");
		verifyTrue(searchPage.areProductsDisplayed("Lenovo IdeaCentre 600 All-in-One PC",
				"Lenovo Thinkpad X1 Carbon Laptop"));

	}

	@Test
	public void TC_04_Absolute_Search_Product() {

		log.info("TC_04_Absolute_Search_Product - Step 01: Input Absolute Product ");
		searchPage.inputToSearchTextbox(absoluteProduct);

		log.info("TC_04_Absolute_Search_Product - Step 02: Click To Search Button ");
		searchPage.clickToSearchButton();

		log.info("TC_04_Absolute_Search_Product - Step 03: Verify 1 Products Appear ");
		verifyTrue(searchPage.isProductsDisplayed("Lenovo Thinkpad X1 Carbon Laptop"));

	}

	@Test
	public void TC_05_Advanced_Search_With_Parent_Categories() {

		log.info("TC_05_Advanced_Search_With_Parent_Categories - Step 01: Input Product Name ");
		searchPage.inputToSearchTextbox(appleProductName);

		log.info("TC_05_Advanced_Search_With_Parent_Categories - Step 02: Check To Advanced Search ");
		searchPage.checkToAdvancedSearchCheckBox();

		log.info("TC_05_Advanced_Search_With_Parent_Categories - Step 03: Choose Category");
		searchPage.selectCategoryDropdown(category);

		log.info("TC_05_Advanced_Search_With_Parent_Categories - Step 04: Click To Search Button ");
		searchPage.clickToSearchButton();

		log.info("TC_05_Advanced_Search_With_Parent_Categories - Step 05: Verify No Result Message ");
		verifyEquals(searchPage.getNoResultMessageText(), "No products were found that matched your criteria.");

	}
	@Test
	public void TC_06_Advanced_Search_With_Sub_Categories() {

		log.info("TC_06_Advanced_Search_With_Sub_Categories - Step 01: Input Product Name ");
		searchPage.inputToSearchTextbox(appleProductName);

		log.info("TC_06_Advanced_Search_With_Sub_Categories - Step 02: Check To Advanced Search ");
		searchPage.checkToAdvancedSearchCheckBox();

		log.info("TC_06_Advanced_Search_With_Sub_Categories - Step 03: Choose Category");
		searchPage.selectCategoryDropdown(category);
		
		log.info("TC_06_Advanced_Search_With_Sub_Categories - Step 04: Check To Search Sub Categories ");
		searchPage.checkToSearchSubCategoriesCheckbox();

		log.info("TC_06_Advanced_Search_With_Sub_Categories - Step 05: Click To Search Button ");
		searchPage.clickToSearchButton();

		log.info("TC_06_Advanced_Search_With_Sub_Categories - Step 06: Verify 1 Products Appear ");
		verifyTrue(searchPage.isProductsDisplayed("Apple MacBook Pro 13-inch"));

	}
	
	@Test
	public void TC_07_Advanced_Search_With_Incorrect_Manufacturer() {

		log.info("TC_07_Advanced_Search_With_Incorrect_Manufacturer - Step 01: Input Product Name ");
		searchPage.inputToSearchTextbox(appleProductName);

		log.info("TC_07_Advanced_Search_With_Incorrect_Manufacturer - Step 02: Check To Advanced Search ");
		searchPage.checkToAdvancedSearchCheckBox();

		log.info("TC_07_Advanced_Search_With_Incorrect_Manufacturer - Step 03: Choose Category");
		searchPage.selectCategoryDropdown(category);
		
		log.info("TC_07_Advanced_Search_With_Incorrect_Manufacturer - Step 04: Check To Search Sub Categories ");
		searchPage.checkToSearchSubCategoriesCheckbox();
		
		log.info("TC_07_Advanced_Search_With_Incorrect_Manufacturer - Step 05: Choose Manufacturer ");
		searchPage.selectManufacturerDropdown(hpManufacturer);

		log.info("TC_07_Advanced_Search_With_Incorrect_Manufacturer - Step 06: Click To Search Button ");
		searchPage.clickToSearchButton();

		log.info("TC_07_Advanced_Search_With_Incorrect_Manufacturer - Step 07: Verify No Result Message ");
		verifyEquals(searchPage.getNoResultMessageText(), "No products were found that matched your criteria.");

	}
	
	@Test
	public void TC_08_Advanced_Search_With_Correct_Manufacturer() {

		log.info("TC_08_Advanced_Search_With_Correct_Manufacturer - Step 01: Input Product Name ");
		searchPage.inputToSearchTextbox(appleProductName);

		log.info("TC_08_Advanced_Search_With_Correct_Manufacturer - Step 02: Check To Advanced Search ");
		searchPage.checkToAdvancedSearchCheckBox();

		log.info("TC_08_Advanced_Search_With_Correct_Manufacturer - Step 03: Choose Category");
		searchPage.selectCategoryDropdown(category);
		
		log.info("TC_08_Advanced_Search_With_Correct_Manufacturer - Step 04: Check To Search Sub Categories ");
		searchPage.checkToSearchSubCategoriesCheckbox();
		
		log.info("TC_08_Advanced_Search_With_Correct_Manufacturer - Step 05: Choose Manufacturer ");
		searchPage.selectManufacturerDropdown(appleManufacturer);

		log.info("TC_08_Advanced_Search_With_Correct_Manufacturer - Step 06: Click To Search Button ");
		searchPage.clickToSearchButton();

		log.info("TC_08_Advanced_Search_With_Correct_Manufacturer - Step 07: Verify 1 Products Appear ");
		verifyTrue(searchPage.isProductsDisplayed("Apple MacBook Pro 13-inch"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (driver != null) {
			// quit trinh duyet
			driver.quit();
		}
	}

}
