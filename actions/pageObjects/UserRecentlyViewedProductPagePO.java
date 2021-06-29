package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import pageUIs.UserRecentlyViewedPageUI;
import pageUIs.UserSearchPageUI;

public class UserRecentlyViewedProductPagePO extends AbstractPage {
	WebDriver driver;

	public UserRecentlyViewedProductPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean areProductsDisplayed(String productName1, String producName2,String producName3) {

		List<WebElement> products = getElements(driver, UserRecentlyViewedPageUI.LIST_ITEM_RESULT_LINK);
		ArrayList<String> actualItems = new ArrayList<String>();
		for (WebElement option : products) {
			actualItems.add(option.getText());
		}
		ArrayList<String> expectedProducts = new ArrayList<String>();
		// add cac item vao mang
		expectedProducts.add(productName1);
		expectedProducts.add(producName2);
		expectedProducts.add(producName3);
		System.out.println("actual: " + actualItems);
		System.out.println("expected: " + expectedProducts);
		if (actualItems.equals(expectedProducts)) {
			System.out.println("if");
			return true;
		

		} else {
			System.out.println("else");
			return false;
		}
	}

}
