package com.nopcommerce.users;

import org.testng.annotations.Test;
import commons.AbstractTest;
import pageObjects.UserAddressPO;
import pageObjects.UserCustomerInforPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserOdersPagePO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserRegisterPO;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Example extends AbstractTest {
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

	public void TC_01_Register() {
		log.info("Register - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToGenderMaleRadioButton();
		registerPage.inputToFirstNameTextbox(firstname);
		registerPage.inputToLastNameTextbox(lastname);
		registerPage.selectDayDropdown("10");
		registerPage.selectMonthDropdown("August");
		registerPage.selectYearDropdown("1995");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToCompanyTextbox(companyName);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		log.info("Register - Step 10: Verify Registered Success Message");
		verifyEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completedxx");

		log.info("Register - Step 11: Verify Registered Success Message");
		verifyEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completedxxv");

		log.info("Register - Step 12: Verify Registered Success Message");
		verifyEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completedxxvv");
		homePage = registerPage.clickToLogoutLink();

	}

	public void TC_02_Login() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 5: Verify My Account Link Displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 6: Verify Logout Link Displayed");
		verifyFalse(homePage.isLogoutLinkDisplayed());

		log.info("Login - Step 7: Verify Logout Link Displayed");
		verifyFalse(homePage.isLogoutLinkDisplayed());

		log.info("Login - Step 8: Verify Register Link Undisplayed");
		verifyTrue(homePage.isRegisterLinkUndisplayed());

	}

	public void TC_03_View_My_Account() {
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isGenderMaleRadioButtonSelected());
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstname);
		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastname);
		Assert.assertEquals(customerInfoPage.getSelectedTextInDayDropdown(), "10");
		Assert.assertEquals(customerInfoPage.getSelectedTextInMonthDropdown(), "August");
		Assert.assertEquals(customerInfoPage.getSelectedTextInYearDropdown(), "1995");
		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), companyName);
		Assert.assertTrue(customerInfoPage.isNewLeterCheckboxSelected());

	}

//	@Test
//	public void TC_04_Switch_Page_Solution_1() {
//		addressPage = (AddressPageObject) customerInfoPage.openLinkByPageName(driver, "Addresses");
//		customerInfoPage = (CustomerInforPageObject) addressPage.openLinkByPageName(driver, "Customer info");
//		myProductReviewPage = (MyProductReviewPageObject) customerInfoPage.openLinkByPageName(driver,
//				"My product reviews");
//	}
	public void TC_04_Switch_Page_Solution_2() {
		customerInfoPage.openLinkByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressesPage(driver);
		addressPage.openLinkByPageName(driver, "Customer info");
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		customerInfoPage.openLinkByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
	}

	@AfterClass
	public void afterClass() {
		// quit trinh duyet
		driver.quit();

	}

}
