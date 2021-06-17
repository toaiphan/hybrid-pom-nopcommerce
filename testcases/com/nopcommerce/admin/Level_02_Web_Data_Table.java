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

public class Level_02_Web_Data_Table extends AbstractTest {

	WebDriver driver;

	@Parameters(value = { "browser", "url" })

	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);
		dashboardPage = loginPage.loginToSystem("admin@yourstore.com", "admin");
		productPage = dashboardPage.openProductPage();
	}

	@Test
	public void TC_01_Data_Table() {
		productPage.goToPageAtTableByIndex("2");
		Assert.assertTrue(productPage.isPageActivedAtTableByIndex("2"));
		productPage.goToPageAtTableByIndex("1");
		Assert.assertTrue(productPage.isPageActivedAtTableByIndex("1"));
		productPage.goToPageAtTableByIndex("3");
		Assert.assertTrue(productPage.isPageActivedAtTableByIndex("3"));
		productPage.goToPageAtTableByIndex("2");
		Assert.assertTrue(productPage.isPageActivedAtTableByIndex("2"));
		productPage.goToPageAtTableByIndex("1");
		Assert.assertTrue(productPage.isPageActivedAtTableByIndex("1"));

	}

	@Test
	public void TC_02_Select_Deselect_All() {
		productPage.checkToSelectAllCheckbox();
		productPage.allProductCheckboxChecked();
		productPage.unCheckToSelectAllCheckbox();
		productPage.allProductCheckboxUnchecked();
		productPage.checkToProductCheckboxByName("Build your own computer");
		productPage.checkToProductCheckboxByName("Digital Storm VANQUISH 3 Custom Performance PC");

	}

	@Test
	public void TC_03_Displayed_All() {
		Assert.assertTrue(
				productPage.areProductDetailDisplayed("Build your own computer", "COMP_CUST", "1200", "10000", "true"));
		productPage.selectShowItemDropdown("50");
		//Assert.assertTrue(productPage.areProductDetailDisplayed("Vintage Style Engagement Ring", "VS_ENG_RN", "2100",
			//	"10000", "false"));
		//ham de check thong tin tai vi tri cot x, hang y
		Assert.assertTrue(productPage.isInformationDisplayedAtColumnNameAndRowNumber("Product name", "2", "Digital Storm VANQUISH 3 Custom Performance PC"));
		Assert.assertTrue(productPage.isPublishStutusAtColumnNameAndRowNumber("Published", "2", "true"));

	}
	
	@Test
	public void TC_04_Edit() {
		productPage.clickToProductDetailByName("Build your own computer");
		productPage.backToPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	AdminLoginPO loginPage;
	AdminDashboardPO dashboardPage;
	AdminProductPO productPage;

}
