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

public class User_01_Register extends AbstractTest {
	WebDriver driver;
	UserHomePO homePage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInfoPage;
	UserRegisterPO registerPage;
	UserAddressPO addressPage;
	UserMyProductReviewPO myProductReviewPage;
	UserOdersPagePO odersPagePage;
	Select select;
	String firstname, lastname, email, companyName, password, invalidEmail, day, month, year;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		firstname = "phan";
		lastname = "toai";
		email = "toaiphan" + getRandomNumber() + "@gmail.com";
		companyName = "company";
		password = "123456";
		invalidEmail = "toaiphan" + getRandomNumber();
		day = "8";
		month = "June";
		year = "1995";
	}

	@Test

	public void TC_01_Register_With_Valid_Information() {

		log.info("Register_With_Valid_Information - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Register_With_Valid_Information - Step 02: Click To Regiser Link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register_With_Valid_Information - Step 03: Choose Gender Male");
		registerPage.clickToGenderMaleRadioButton();

		log.info("Register_With_Valid_Information - Step 04: Input First Name");
		registerPage.inputToFirstNameTextbox(firstname);

		log.info("Register_With_Valid_Information - Step 05: Input Last Name");
		registerPage.inputToLastNameTextbox(lastname);

		log.info("Register_With_Valid_Information - Step 06: Choose Day Of Birth");
		registerPage.selectDayDropdown(day);

		log.info("Register_With_Valid_Information - Step 07: Choose Month Of Birth");
		registerPage.selectMonthDropdown(month);

		log.info("Register_With_Valid_Information - Step 08: Choose Year Of Birth");
		registerPage.selectYearDropdown(year);

		log.info("Register_With_Valid_Information - Step 09: Input Email");
		registerPage.inputToEmailTextbox(email);

		log.info("Register_With_Valid_Information - Step 10: Input Company Name");
		registerPage.inputToCompanyTextbox(companyName);

		log.info("Register_With_Valid_Information - Step 11: Input Password");
		registerPage.inputToPasswordTextbox(password);

		log.info("Register_With_Valid_Information - Step 12: Input Confirm Password");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register_With_Valid_Information - Step 13: Click To Regiser Link");
		registerPage.clickToRegisterButton();

		log.info("Register_With_Valid_Information - Step 14: Verify Registered Susscess Message ");
		verifyEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completed");

	}

	@Test
	public void TC_02_Register_With_Empty_Data() {
		log.info("Register_With_Empty_Data - Step 01: Click To LogOut");
		registerPage.clickToLogoutLink();

		log.info("Register_With_Empty_Data - Step 02: Click To Regiser Link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register_With_Empty_Data - Step 03: Click To Regiser Button");
		registerPage.clickToRegisterButton();

		log.info("Register_With_Empty_Data - Step 04: Verify Error Message (First name is required.)");
		verifyEquals(registerPage.getFirstNameIsRequiredMessage(), "First name is required.");

		log.info("Register_With_Empty_Data - Step 05: Verify Error Message (Last name is required.)");
		verifyEquals(registerPage.getLastNameIsRequiredMessage(), "Last name is required.");

		log.info("Register_With_Empty_Data - Step 06: Verify Error Message (Password is required.)");
		verifyEquals(registerPage.getPasswordIsRequiredMessage(), "Password is required.");
	}

	@Test
	public void TC_03_Register_With_Invalid_Email() {

		log.info("Register_With_Invalid_Email - Step 01: Input Invalid Email");
		registerPage.inputToEmailTextbox(invalidEmail);

		log.info("Register_With_Invalid_Email - Step 02: Verify Error Message (Wrong email)");
		verifyEquals(registerPage.getWrongEmailMessage(), "Wrong email");

	}

	@AfterClass
	public void afterClass() {
		// quit trinh duyet
		driver.quit();

	}

}
