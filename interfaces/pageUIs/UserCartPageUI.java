package pageUIs;

public class UserCartPageUI {
	public static final String PRODUCT_DETAIL_IN_TABLE = " //a[text()='%s']//parent::td//following-sibling::td/span[text()='%s']//parent::td//following-sibling::td/input[@value='%s']//parent::td//following-sibling::td/span[text()='%s']";
	public static final String WIST_LIST_LINK = "//span[@class='wishlist-label']";
	public static final String EDIT_CART = "//a[contains(text(),'Edit')]";
	public static final String REMOVE_BUTTON = "//button[@class='remove-btn']";
	public static final String NO_DATA_MESSAGE = "//div[@class='no-data']";
	public static final String UPDATE_BUTTON = "//button[contains(text(),'Update shopping cart')]";
	public static final String HOMEPAGE_LINK = "//img[@alt='nopCommerce demo store']";
	public static final String PRODUCT_QUANTITY_TEXTBOX = "//input[@id='itemquantity11243']";
	
	public static final String WRAPPING_DROPDOWN ="//select[@id='checkout_attribute_1']";
	public static final String AGREE_TERM_CHECKBOX ="//input[@id='termsofservice']";
	public static final String CHECK_OUT_BUTTON ="//button[@id='checkout']";
}
