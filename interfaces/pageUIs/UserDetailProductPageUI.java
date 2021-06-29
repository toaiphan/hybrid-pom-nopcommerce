package pageUIs;

public class UserDetailProductPageUI {
	// public : co the su trong o moi noi trong project
	// static : khong can phai new doi tuong, van co the su dung duoc
	// final : khong the gan lai trong qua trinh chay
	// static+final = hang so, ko thay doi duoc
	// String : vi trong abstractPage su dung locator kieu String
	// REGISTER_LINK : cu phap cua hang so trong java

	public static final String ADD_REVIEW_BUTTON = "//a[contains(text(),'Add your review')]";
	public static final String ADD_TO_WISTLIST_BUTTON = "//div[@class='add-to-wishlist']//button[text()='Add to wishlist']";
	public static final String ADDED_SUCCESS_MESSAGE = "//p[@class='content']";
	public static final String CLOSE_ADDED_SUCCESS_MESSAGE_BUTTON = "//span[@class='close']";
	public static final String WIST_LIST_LINK = "//span[@class='wishlist-label']";
	public static final String HOME_PAGE_LINK = "//img[@alt='nopCommerce demo store']";

	public static final String PROCESSER_DROPDOWN = "//select[@id='product_attribute_1']";
	public static final String RAM_DROPDOWN = "//select[@id='product_attribute_2']";

	public static final String HDD_400GB_RADIO_BUTTON = "//input[@id='product_attribute_3_7']";
	public static final String HDD_320GB_RADIO_BUTTON = "//input[@id='product_attribute_3_6']";

	public static final String OS_VISTA_HOME_RADIO_BUTTON = "//input[@id='product_attribute_4_8']";
	public static final String OS_VISTA_PRIMIUM_RADIO_BUTTON = "//input[@id='product_attribute_4_9']";

	public static final String MICROSOFT_CHECKBOX = "//input[@id='product_attribute_5_10']";
	public static final String ACROBAT_READER_CHECKBOX = "//input[@id='product_attribute_5_11']";
	public static final String TOTAL_COMMANDER_CHECKBOX = "//input[@id='product_attribute_5_12']";
	public static final String ADD_TO_CART_BUTTON = "//button[@id='add-to-cart-button-1']";
	public static final String ADDED_CART_SUCCESS_MESSAGE = "//p[@class='content']";
	public static final String CLOSE_MESSAGE_BUTTON = "//span[@class='close']";
	
	public static final String CART_LINK ="//span[@class='cart-label']";
	
	public static final String PRICE_TEXT = "//span[@id='price-value-1']";
	public static final String PRODUCT_QUANTITY_TEXTBOX = "//input[@id='product_enteredQuantity_1']";
	public static final String PRODUCT_DETAIL_IN_TABLE = "//a[text()='%s']//parent::td//following-sibling::td/span[text()='%s']//parent::td//following-sibling::td/input[@value='%s']//parent::td//following-sibling::td/span[text()='%s']";
}
