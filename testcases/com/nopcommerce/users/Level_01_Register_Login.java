package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import pageObjects.CustomerInforPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//
//--------------------------------Các bước viết script dạng Page Object Pattern-----------------------------//
//1. Tạo các pageObject class ( chưa viết gì)
//2. Tạo các pageUI Class ( viết các locator trong đó)
//3. Viết các hàm giả trong testcase
//4. Từ các hàm giả tạo hàm và viết các hàm trong pageObject class (TDD Test-Driven-Development )
//DRY : Dont repeat yourself : lap lai nhieu se mat nhieu thoi gian maintain

//--------------------fake data:mockaroo.com--------------------------//
//--------------------Cloud testing service-------------------------//
//Browser stack, Saucelab, Device farm(Amazone).. Dung de chay tren da dang he dieu hanh+ Webbrowser+ Version

//--------------------Selenium architect-------------------------//
//tester viet code bằng ngôn ngữ lập trình :Java,python,C#... ==compile ra ngôn ngữ máy(file.class)==> máy tính
//=== protocol(Json wire)===> driver === http/s===>browsers

//-------------------- neu load trang lau, bi fail ,co the dung JS topic 38 (9h12p goc window)------ hoac bo info vi che nut logout-//
public class Level_01_Register_Login extends AbstractTest {
	// Khai bao projectFolder

	// khai bao driver
	WebDriver driver;

	// khai bao bien select cho dropdown
	Select select;

	// Khai bao firstname,lastname,email,companyName,password;
	String firstname, lastname, email, companyName, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);


		// tao bo du lieu (email se +4 so random)
		firstname = "phan";
		lastname = "toai";
		email = "toaiphan" + getRandomNumber() + "@gmail.com";
		companyName = "company";
		password = "123456";
	}

	@Test
	public void TC_01_Register() {

		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
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
		Assert.assertEquals(registerPage.getRegisteredSuccessMessage(), "Your registration completed");
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);

	}

	@Test
	public void TC_02_Login() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_View_My_Account() {
		homePage.clickToMyAccountLink();
		customerInfoPage = new CustomerInforPageObject(driver);
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

	// viet ham random cho email getRandomNumber

	

	@AfterClass
	public void afterClass() {
		// quit trinh duyet
		driver.quit();

	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	CustomerInforPageObject customerInfoPage;
	RegisterPageObject registerPage;
}
