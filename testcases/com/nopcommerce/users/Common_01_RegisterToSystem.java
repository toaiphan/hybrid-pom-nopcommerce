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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Common_01_RegisterToSystem extends AbstractTest {
	WebDriver driver;
	UserHomePO homePage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInfoPage;
	UserRegisterPO registerPage;
	UserAddressPO addressPage;
	UserMyProductReviewPO myProductReviewPage;
	UserOdersPagePO odersPagePage;
	public static String USERNAME,PASSWORD; 
	Select select;
	String firstname, lastname, email, companyName, password, invalidEmail, day, month, year, existEmail,
			invalidPassword, notMatchPassword;

	@Parameters(value = { "browser", "url" })
	@BeforeTest
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
		invalidPassword = "12345";
		notMatchPassword = "1234567";

		log.info("Register - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Register - Step 02: Click To Regiser Link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 03: Choose Gender Male");
		registerPage.clickToGenderMaleRadioButton();

		log.info("Register - Step 04: Input First Name");
		registerPage.inputToFirstNameTextbox(firstname);

		log.info("Register - Step 05: Input Last Name");
		registerPage.inputToLastNameTextbox(lastname);

		log.info("Register - Step 06: Choose Day Of Birth");
		registerPage.selectDayDropdown(day);

		log.info("Register - Step 07: Choose Month Of Birth");
		registerPage.selectMonthDropdown(month);

		log.info("Register - Step 08: Choose Year Of Birth");
		registerPage.selectYearDropdown(year);

		log.info("Register - Step 09: Input Email");
		registerPage.inputToEmailTextbox(email);
		existEmail = email;

		log.info("Register - Step 10: Input Company Name");
		registerPage.inputToCompanyTextbox(companyName);

		log.info("Register - Step 11: Input Password");
		registerPage.inputToPasswordTextbox(password);

		log.info("Register - Step 12: Input Confirm Password");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register - Step 13: Click To Regiser Link");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 14: get User_Password Information");
		USERNAME= registerPage.getUserInformation(email);
		PASSWORD= registerPage.getPasswordInformation(password);	
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	
		driver.quit();
	}



}
