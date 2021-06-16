package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminDashboardPageUI;

public class AdminDashboardPO extends AbstractPage {
	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminProductPO openProductPage() {
		waitToElementClickable(driver, AdminDashboardPageUI.CATALOG_TEXT_AT_SIDEBAR);
		clickToElement(driver, AdminDashboardPageUI.CATALOG_TEXT_AT_SIDEBAR);
		waitToElementClickable(driver, AdminDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);
		clickToElement(driver, AdminDashboardPageUI.PRODUCT_LINK_AT_SIDEBAR);

		return PageGeneratorManager.getAdminProductPage(driver);
	}
}