package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.AbstractPage;
import pageObjects.CustomerInforPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import pageUIs.HomePageUI;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

//DRY : Dont repeat yourself : lap lai nhieu se mat nhieu thoi gian maintain
public class Level_01_Register_Login extends AbstractPage {
	// Khai bao projectFolder
	String projectFolder = System.getProperty("user.dir");

	// khai bao driver
	WebDriver driver;

	// khai bao bien select cho dropdown
	Select select;

	// Khai bao firstname,lastname,email,companyName,password;
	String firstname, lastname, email, companyName, password;

	@BeforeClass
	public void beforeClass() {
		// set geko driver

		System.setProperty("webdriver.gecko.driver", projectFolder + "/browserDriver/geckodriver.exe");
		// khoi tao driver
		driver = new FirefoxDriver();

		// khoi tao implicit wait 30s
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

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

	// @Test
	public void TC_02_Login() {

	}

	// @Test
	public void TC_03_View_My_Account() {

	}

	// viet ham random cho email getRandomNumber

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);

	}

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
