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
		
		log.info("Pre-condition - Step 05: Click To Search Link In Footer");
		searchPage = homePage.clickToLinkInFooterbyName("Search");
	}

	@Test
	public void TC_01_Search_With_Empty_Data() {
		log.info("TC_01_Search_With_Empty_Data - Step 01: Click To Search Button ");
		searchPage.clickToSearchButton();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (driver != null) {
			// quit trinh duyet
			driver.quit();
		}
	}

}
