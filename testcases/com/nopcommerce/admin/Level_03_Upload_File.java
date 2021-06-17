package com.nopcommerce.admin;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AdminDashboardPO;
import pageObjects.AdminLoginPO;
import pageObjects.AdminProductPO;
import pageObjects.PageGeneratorManager;
import pageObjects.UserHomePO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Upload_File extends AbstractTest {

	WebDriver driver;
	String fileName = "hanoi.jpg";

	@Parameters(value = { "browser", "url" })

	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);
		dashboardPage = loginPage.loginToSystem("admin@yourstore.com", "admin");
		productPage = dashboardPage.openProductPage();
	}

	
	@Test
	public void TC_01_Upload_file() {
		productPage.inputToProductNameTextbox("");
		productPage.clickToSearchTextbox();
		productPage.clickToProductDetailByName("Build your own computer");
		productPage.scrollToPicturePanel();
		productPage.uploadFileByPanelID(driver, "product-pictures", fileName);
		productPage.inputToAltTextbox("");
		productPage.inputToTitleTextbox("");

		productPage.inputToOrderTextbox("");
		productPage.clickToAddProductPictureButton();
		Assert.assertTrue(productPage.areImageDetailDisplayed("Build your own computer","1","Alt","Title"));
		productPage.clickToSaveButton();
		productPage.inputToProductNameTextbox("");
		productPage.clickToSearchTextbox();
		Assert.assertTrue(productPage.areProductDisplayed("Image name","Build your own computer", "COMP_CUST", "1200", "10000", "true"));
		productPage.clickToProductDetailByName("Build your own computer");
		productPage.scrollToPicturePanel();
		productPage.clickToDeleteButton();
		productPage.clickToSaveButton();
		productPage.inputToProductNameTextbox("");
		productPage.clickToSearchTextbox();
		Assert.assertTrue(productPage.areProductDisplayed("default-image","Build your own computer", "COMP_CUST", "1200", "10000", "true"));

		
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	AdminLoginPO loginPage;
	AdminDashboardPO dashboardPage;
	AdminProductPO productPage;

}
