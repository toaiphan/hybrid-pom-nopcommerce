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
		// khoi tao abtractPage

		// mo trang demo.nopcommerce.com
		// driver.get("https://demo.nopcommerce.com/");

		// mo URl su dung ham common
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
		

		// click vao register
//		driver.findElement(By.className("ico-register")).click();
//
//		// click vao male
//		driver.findElement(By.id("gender-male")).click();
//
//		// sendkeys vao firstname
//		driver.findElement(By.id("FirstName")).sendKeys(firstname);
//
//		// sendkeys vao lastname
//		driver.findElement(By.id("LastName")).sendKeys(lastname);
//
//		// khoi tao select cho birthday
//		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
//		// chon birthday ,su dung selecByvisible
//		select.selectByVisibleText("8");
//		// khoi tao select cho Birth month
//		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
//		// chon month ,su dung selecByvisible
//		select.selectByVisibleText("June");
//		// khoi tao select cho year
//		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
//
//		// chon year ,su dung selecByvisible
//		select.selectByVisibleText("1995");
//
//		// sendkeys vao email
//		driver.findElement(By.id("Email")).sendKeys(email);
//
//		// sendkeys vao company name
//		driver.findElement(By.id("Company")).sendKeys(companyName);
//
//		// sendkeys vao pass
//		driver.findElement(By.id("Password")).sendKeys(password);
//
//		// sendkeys vao confirm pass
//		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
//
//		// click register
//		driver.findElement(By.id("register-button")).click();
//		// verify da dang ki thanh cong
//		Assert.assertEquals(driver.findElement(By.className("result")).getText(), "Your registration completed");
//		// click logout
//		driver.findElement(By.className("ico-logout")).click();

	}

	// @Test
	public void TC_02_Login() {

		// click login
		driver.findElement(By.className("ico-login")).click();
		// send email+pass
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);

		// click vao login
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

		// verify : my account displayed,log out displayed
		Assert.assertTrue(driver.findElement(By.className("ico-account")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.className("ico-logout")).isDisplayed());

	}

	// @Test
	public void TC_03_View_My_Account() {

		// click vao my account
		driver.findElement(By.className("ico-account")).click();
		// kiem tra male gender da duoc check roi
		driver.findElement(By.id("gender-male")).isSelected();
		// verify cac thong tin trung voi thoi tin da dang ki
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstname);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastname);
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "8");
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "June");
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "1995");
		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), email);
		Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), companyName);

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
