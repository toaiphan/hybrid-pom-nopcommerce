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
	String firstname, lastname, email, companyName, password;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		firstname = "phan";
		lastname = "toai";
		email = "toaiphan" + getRandomNumber() + "@gmail.com";
		companyName = "company";
		password = "123456";
	}

	@Test
	public void TC_01_Register_With_Empty_Data() {

		log.info("Register - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Register - Step 02: Click To Regiser Link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 03: Click To Regiser Link");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 04: Verify Error Message (First name is required.)");
		verifyEquals(registerPage.getFirstNameIsRequiredMessage(), "First name is required.");

		log.info("Register - Step 05: Verify Error Message (Last name is required.)");
		verifyEquals(registerPage.getLastNameIsRequiredMessage(), "Last name is required.");
		
		log.info("Register - Step 06: Verify Error Message (Password is required.)");
		verifyEquals(registerPage.getPasswordIsRequiredMessage(), "Password is required.");
	}

	@AfterClass
	public void afterClass() {
		// quit trinh duyet
		driver.quit();

	}

}
