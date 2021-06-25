package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import commons.AbstractPage;
import pageUIs.AdminProductPageUI;
import pageUIs.UserRegisterPageUI;
import pageUIs.UserSearchPageUI;

public class UserSearchPagePO extends AbstractPage {
	WebDriver driver;

	public UserSearchPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitToElementClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}

	public String getEmptyErrorMessageText() {
		waitToElementVisible(driver, UserSearchPageUI.EMPTY_ERROR_MESSAGE);
		return getElementText(driver, UserSearchPageUI.EMPTY_ERROR_MESSAGE);
	}

	public void inputToSearchTextbox(String dataNotExist) {
		waitToElementVisible(driver, UserSearchPageUI.SEARCH_TEXTBOX);
		sendKeyToElement(driver, UserSearchPageUI.SEARCH_TEXTBOX, dataNotExist);

	}

	public String getNoResultMessageText() {
		waitToElementVisible(driver, UserSearchPageUI.NO_RESULT_ERROR_MESSAGE);
		return getElementText(driver, UserSearchPageUI.NO_RESULT_ERROR_MESSAGE);
	}

	public boolean areProductsDisplayed(String productName1, String producName2) {

		List<WebElement> products = getElements(driver, UserSearchPageUI.LIST_ITEM_RESULT_LINK);
		ArrayList<String> actualItems = new ArrayList<String>();
		for (WebElement option : products) {
			actualItems.add(option.getText());
		}
		ArrayList<String> expectedProducts = new ArrayList<String>();
		// add cac item vao mang
		expectedProducts.add(productName1);
		expectedProducts.add(producName2);
		System.out.println(actualItems);
		System.out.println(expectedProducts);
		if (actualItems.equals(expectedProducts)) {
			System.out.println("if");
			return true;
		

		} else {
			System.out.println("else");
			return false;
		}
	}

	public boolean isProductsDisplayed(String productName1) {
		List<WebElement> products = getElements(driver, UserSearchPageUI.LIST_ITEM_RESULT_LINK);
		ArrayList<String> actualItems = new ArrayList<String>();
		for (WebElement option : products) {
			actualItems.add(option.getText());
		}
		ArrayList<String> expectedProducts = new ArrayList<String>();
		// add cac item vao mang
		expectedProducts.add(productName1);
		System.out.println(actualItems);
		System.out.println(expectedProducts);
		if (actualItems.equals(expectedProducts)) {
			System.out.println("if");
			return true;

		} else {
			System.out.println("else");
			return false;
		}
	}

	public void checkToAdvancedSearchCheckBox() {
		waitToElementClickable(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
		checkToCheckBox(driver, UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
	}

	public void selectCategoryDropdown(String category) {
		waitToElementClickable(driver, UserSearchPageUI.CATEGORY_DROPDOWN);
		selectItemInDropdown(driver, UserSearchPageUI.CATEGORY_DROPDOWN, category);
	}

	public void checkToSearchSubCategoriesCheckbox() {
		waitToElementClickable(driver, UserSearchPageUI.AUTO_SEARCH_SUB_CATEGORY_CHECKBOX);
		checkToCheckBox(driver, UserSearchPageUI.AUTO_SEARCH_SUB_CATEGORY_CHECKBOX);
		
	}

	public void selectManufacturerDropdown(String hpManufacturer) {
		waitToElementClickable(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDropdown(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN, hpManufacturer);		
	}
}
