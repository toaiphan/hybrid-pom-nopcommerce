package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstractPage;
import pageUIs.AdminProductPageUI;

public class AdminProductPO extends AbstractPage {
	WebDriver driver;

	public AdminProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public void goToPageAtTableByIndex(String indexPage) {
		waitToElementClickable(driver, AdminProductPageUI.PAGING_AT_TABLE_BY_INDEX, indexPage);
		clickToElement(driver, AdminProductPageUI.PAGING_AT_TABLE_BY_INDEX, indexPage);
	}

	public boolean isPageActivedAtTableByIndex(String indexPage) {
		waitToElementVisible(driver, AdminProductPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX, indexPage);
		return isElementDisplayed(driver, AdminProductPageUI.PAGING_AT_TABLE_ACTIVE_BY_INDEX, indexPage);
	}

	public void checkToSelectAllCheckbox() {
		waitToElementClickable(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		checkToCheckBox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
	}

	public void unCheckToSelectAllCheckbox() {
		waitToElementClickable(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		uncheckToCheckBox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);

	}

	public void allProductCheckboxChecked() {
		List<WebElement> allProductCheckboxes = getElements(driver, AdminProductPageUI.ALL_PRODUCT_CHECKBOX);
		for (WebElement productCheckbox : allProductCheckboxes) {
			Assert.assertTrue(productCheckbox.isSelected());

		}

	}

	public void allProductCheckboxUnchecked() {
		List<WebElement> allProductCheckboxes = getElements(driver, AdminProductPageUI.ALL_PRODUCT_CHECKBOX);
		for (WebElement productCheckbox : allProductCheckboxes) {
			Assert.assertFalse(productCheckbox.isSelected());

		}

	}

	public void checkToProductCheckboxByName(String productName) {
		waitToElementClickable(driver, AdminProductPageUI.PRODUCT_CHECKBOX_BY_NAME, productName);
		checkToCheckBox(driver, AdminProductPageUI.PRODUCT_CHECKBOX_BY_NAME, productName);

	}

	public boolean areProductDetailDisplayed(String productName, String skuID, String price, String quantity,
			String publicStatus) {
		waitToElementVisible(driver, AdminProductPageUI.PRODUCT_DETAIL_IN_TABLE, productName, skuID, price, quantity,
				publicStatus);

		return isElementDisplayed(driver, AdminProductPageUI.PRODUCT_DETAIL_IN_TABLE, productName, skuID, price,
				quantity, publicStatus);
	}

	public void selectShowItemDropdown(String itemNumber) {
		waitToElementClickable(driver, AdminProductPageUI.SHOW_NUMBER_ITEM_DROPDOWN);
		selectItemInDropdown(driver, AdminProductPageUI.SHOW_NUMBER_ITEM_DROPDOWN, itemNumber);

	}

	public boolean isInformationDisplayedAtColumnNameAndRowNumber(String culumeName, String rowIndex,
			String expectedValue) {
		// lay ra index cua column name
		int columnNameIndex = countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING, culumeName) + 1;
		String actualValue = getElementText(driver, AdminProductPageUI.CELL_VALUE_MIX_BY_COLUMN_AND_ROW_INDEX, rowIndex,
				String.valueOf(columnNameIndex));
		return actualValue.equals(expectedValue);
	}

	public boolean isPublishStutusAtColumnNameAndRowNumber(String culumeName, String rowIndex, String publishStatus) {
		// lay ra index cua column name
		int columnNameIndex = countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING, culumeName) + 1;
		return isElementDisplayed(driver, AdminProductPageUI.PUBLISH_STATUS_MIX_BY_COLUMN_AND_ROW_INDEX, rowIndex,
				String.valueOf(columnNameIndex), publishStatus);

	}

	public void clickToProductDetailByName(String productName) {
		waitToElementClickable(driver, AdminProductPageUI.EDIT_ICON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, AdminProductPageUI.EDIT_ICON_BY_PRODUCT_NAME, productName);
	}
}
