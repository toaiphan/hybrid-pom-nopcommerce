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

public class User_03_My_Account extends AbstractTest {
	WebDriver driver;
	UserHomePO homePage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInfoPage;
	UserRegisterPO registerPage;
	UserAddressPO addressPage;
	UserMyProductReviewPO myProductReviewPage;
	UserOdersPagePO odersPagePage;
	Select select;
	String firstName, lastName, day, month, year, companyName, email, password, invalidEmail, notMatchPassword, country,
			state, city, address1, address2, zip, phone, fax;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		email = "hahang" + getRandomNumber() + "@gmail.com";
		password = "123456";
		firstName = "Hang";
		lastName = "Ha";
		day = "15";
		month = "May";
		year = "1997";
		companyName = "Viettel";
		country = "United States";
		state = "Alabama";
		city = "Ha Noi";
		address1 = "222 Dinh Thon";
		address2 = "234 Dinh Thon";
		zip = "550000";
		phone = "123456789";
		fax = "987654321";

		log.info("Pre-condition - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 02: Click To Login Link");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-condition - Step 03: Input Username,Password");
		loginPage.inputToEmailTextbox(Common_01_RegisterToSystem.USERNAME);
		loginPage.inputToPasswordTextbox(Common_01_RegisterToSystem.PASSWORD);

		log.info("Pre-condition - Step 04: Click To Login Button");
		homePage = loginPage.clickToLoginButton();
	}

	@Test
	public void TC_01_Update_Customer_Info() {
		log.info("TC_01_Update_Customer_Info - Step 01: Click To My Account ");
		customerInfoPage = homePage.clickToMyAccountLink();

		log.info("TC_01_Update_Customer_Info - Step 02: Choose Famale ");
		customerInfoPage.clickToFamaleRadioButton();

		log.info("TC_01_Update_Customer_Info - Step 03: Input New First Name");
		customerInfoPage.inputToFirstNameTextbox(firstName);

		log.info("TC_01_Update_Customer_Info - Step 04: Input New Last Name");
		customerInfoPage.inputToLastNameTextbox(lastName);

		log.info("TC_01_Update_Customer_Info - Step 05: Slect Day Of Birth");
		customerInfoPage.selectDayDropdown(day);

		log.info("TC_01_Update_Customer_Info - Step 06: Select Month Of Birth");
		customerInfoPage.selectMonthDropdown(month);

		log.info("TC_01_Update_Customer_Info - Step 07: Select Year Of Birth");
		customerInfoPage.selectYearDropdown(year);

		log.info("TC_01_Update_Customer_Info - Step 08: Input New Email ");
		customerInfoPage.inputToEmailTextbox(email);

		log.info("TC_01_Update_Customer_Info - Step 09: Input New Company Name");
		customerInfoPage.inputToCompanyTextbox(companyName);

		log.info("TC_01_Update_Customer_Info - Step 10: Click To Save");
		customerInfoPage.clickToSaveButton();

		log.info("TC_01_Update_Customer_Info - Step 11: Verify Gender Updated");
		verifyTrue(customerInfoPage.isGenderFamaleRadioButtonSelected());

		log.info("TC_01_Update_Customer_Info - Step 12: Verify First Name Updated");
		verifyEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);

		log.info("TC_01_Update_Customer_Info - Step 13: Verify LastName Updated");
		verifyEquals(customerInfoPage.getLastNameTextboxValue(), lastName);

		log.info("TC_01_Update_Customer_Info - Step 14: Verify Day Of Birth Updated");
		verifyEquals(customerInfoPage.getSelectedTextInDayDropdown(), day);

		log.info("TC_01_Update_Customer_Info - Step 15: Verify Month Of Birth Updated");
		verifyEquals(customerInfoPage.getSelectedTextInMonthDropdown(), month);

		log.info("TC_01_Update_Customer_Info - Step 16: Verify Year Of Birth Updated");
		verifyEquals(customerInfoPage.getSelectedTextInYearDropdown(), year);

		log.info("TC_01_Update_Customer_Info - Step 17: Verify Email Updated");
		verifyEquals(customerInfoPage.getEmailTextboxValue(), email);

		log.info("TC_01_Update_Customer_Info - Step 18: Verify Company Name");
		verifyEquals(customerInfoPage.getCompanyTextboxValue(), companyName);

	}

	@Test
	public void TC_02_Add_New_Address() {
		log.info("TC_02_Add_New_Address - Step 01: Click To Addresses ");
		customerInfoPage.openLinkWithPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressesPage(driver);
		
		log.info("TC_02_Add_New_Address - Step 02: Click To Add New ");
		addressPage.clickToAddNewButton();
		
		log.info("TC_02_Add_New_Address - Step 03: Input FirstName ");
		addressPage.inputToFirstNameTextbox(firstName);

		log.info("TC_02_Add_New_Address - Step 04: Input LastName ");
		addressPage.inputToLastNameTextbox(lastName);

		log.info("TC_02_Add_New_Address - Step 05: Input Email ");
		addressPage.inputToEmailTextbox(email);

		log.info("TC_02_Add_New_Address - Step 06: Input Company ");
		addressPage.inputToCompanyTextbox("companyName");

		log.info("TC_02_Add_New_Address - Step 07: Select Country ");
		addressPage.selectCountryDropdown(country);

		log.info("TC_02_Add_New_Address - Step 08: Select State ");
		addressPage.selectStateDropdown(state);

		log.info("TC_02_Add_New_Address - Step 09: Input City ");
		addressPage.inputToCityTextbox(city);

		log.info("TC_02_Add_New_Address - Step 10: Input Address1 ");
		addressPage.inputToAddress1Textbox(address1);

		log.info("TC_02_Add_New_Address - Step 11: Input Address2 ");
		addressPage.inputToAddress2Textbox(address2);

		log.info("TC_02_Add_New_Address - Step 12: Input Zip ");
		addressPage.inputToZipTextbox(zip);

		log.info("TC_02_Add_New_Address - Step 13: Input Phone ");
		addressPage.inputToPhoneTextbox(phone);

		log.info("TC_02_Add_New_Address - Step 14: Fax");
		addressPage.inputToFaxTextbox(fax);

		log.info("TC_02_Add_New_Address - Step 15: Click To Save");
		addressPage.clickToSaveButton();

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (driver != null) {
			// quit trinh duyet
			driver.quit();
		}
	}

}
