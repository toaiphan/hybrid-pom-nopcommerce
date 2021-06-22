package com.nopcommerce.users;

import commons.AbstractTest;
import pageObjects.PageGeneratorManager;
import pageObjects.UserAddressPO;
import pageObjects.UserCustomerInforPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserOdersPagePO;
import pageObjects.UserRegisterPO;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class User_02_Login extends AbstractTest {
	WebDriver driver;
	UserHomePO homePage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInfoPage;
	UserRegisterPO registerPage;
	UserAddressPO addressPage;
	UserMyProductReviewPO myProductReviewPage;
	UserOdersPagePO odersPagePage;
	Select select;
	String email, password, invalidEmail,
		 notMatchPassword;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);	
		email = "toaiphan" + getRandomNumber() + "@gmail.com";
		password = "123456";
		invalidEmail = "toaiphan" + getRandomNumber();
		notMatchPassword = "1234567";

		log.info("Pre-condition - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 02: Click To Login Link");
		loginPage = homePage.clickToLoginLink();
	}

	@Test
	public void TC_01_Login_With_Empty_Data() {

		log.info("TC_01_Login_With_Empty_Data - Step 01: Click To Login");
		loginPage.clickToLoginButton();

		log.info("TC_01_Login_With_Empty_Data - Step 02: Verify Email Error Message(Please enter your email)");
		verifyEquals(loginPage.getEmailErrorMessage(), "Please enter your email");

	}

	@Test
	public void TC_02_Login_With_Invalid_Email() {

		log.info("TC_02_Login_With_Invalid_Email - Step 01: Input Invalid Email");
		loginPage.inputToEmailTextbox(invalidEmail);

		log.info("TC_02_Login_With_Invalid_Email - Step 02: Input Password");
		loginPage.inputToPasswordTextbox(password);

		log.info("TC_02_Login_With_Invalid_Email - Step 03: Click To Login");
		loginPage.clickToLoginButton();

		log.info("TC_02_Login_With_Invalid_Email - Step 04: Verify Email Error Message(Wrong email)");
		verifyEquals(loginPage.getEmailErrorMessage(), "Wrong email");

	}

	@Test
	public void TC_03_Login_With_Unregisterd_Email() {

		log.info("TC_03_Login_With_Unregisterd_Email - Step 01: Input Email");
		loginPage.inputToEmailTextbox(email);

		log.info("TC_03_Login_With_Unregisterd_Email - Step 02: Input Password");
		loginPage.inputToPasswordTextbox(password);

		log.info("TC_03_Login_With_Unregisterd_Email - Step 03: Click To Login");
		loginPage.clickToLoginButton();

		log.info("TC_03_Login_With_Unregisterd_Email - Step 04: Verify No AccountFound Message()");
		verifyEquals(loginPage.getNoAccountFoundMessage(), "No customer account found");

	}

	@Test
	public void TC_04_Login_With_Empty_Password() {

		log.info("TC_04_Login_With_Empty_Password - Step 01: Input Email");
		loginPage.inputToEmailTextbox(Common_01_RegisterToSystem.USERNAME);

		log.info("TC_04_Login_With_Empty_Password - Step 02: Input Password");
		loginPage.inputToPasswordTextbox("");

		log.info("TC_04_Login_With_Empty_Password - Step 03: Click To Login");
		loginPage.clickToLoginButton();

		log.info("TC_04_Login_With_Empty_Password - Step 04: Verify The credentials provided are incorrect Message");
		verifyEquals(loginPage.getCredentialIncorrectMessage(), "The credentials provided are incorrect");

	}

	@Test
	public void TC_05_Login_With_Wrong_Password() {

		log.info("TC_05_Login_With_Wrong_Password - Step 01: Input Email");
		loginPage.inputToEmailTextbox(Common_01_RegisterToSystem.USERNAME);

		log.info("TC_05_Login_With_Wrong_Password - Step 02: Input Password");
		loginPage.inputToPasswordTextbox(notMatchPassword);

		log.info("TC_05_Login_With_Wrong_Password - Step 03: Click To Login");
		loginPage.clickToLoginButton();

		log.info("TC_05_Login_With_Wrong_Password - Step 04: Verify The credentials provided are incorrect Message");
		verifyEquals(loginPage.getCredentialIncorrectMessage(), "The credentials provided are incorrect");

	}

	@Test
	public void TC_06_Login_With_True_Information() {

		log.info("TC_06_Login_With_True_Information - Step 01: Input Email");
		loginPage.inputToEmailTextbox(Common_01_RegisterToSystem.USERNAME);

		log.info("TC_06_Login_With_True_Information - Step 02: Input Password");
		loginPage.inputToPasswordTextbox(Common_01_RegisterToSystem.PASSWORD);

		log.info("TC_06_Login_With_True_Information - Step 03: Click To Login");
		homePage = loginPage.clickToLoginButton();

		log.info("TC_06_Login_With_True_Information - Step 04: Verify Login Susscess");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (driver != null) {
			// quit trinh duyet
			driver.quit();
		}
	}

}
