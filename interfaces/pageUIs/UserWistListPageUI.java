package pageUIs;

public class UserWistListPageUI {
	public static final String SHARE_LINK = "//a[@class='share-link']";
	public static final String PRODUCT_DETAIL_IN_TABLE = "//span[text()='%s']/parent::td//following-sibling::td[@class='product']/a[text()='%s']/parent::td//following-sibling::td[@class='unit-price']/span[text()='%s']/parent::td//following-sibling::td[@class='quantity']/input[@value='%s']/parent::td//following-sibling::td[@class='subtotal']/span[text()='%s']";
	public static final String WIST_LIST_OF_TEXT = "//h1[contains(text(),'Wishlist of')]";
	public static final String PRODUCT_DETAIL_IN_TABLE_IN_SHARE_LINK = "//span[text()='%s']/parent::td//following-sibling::td[@class='product']/a[text()='%s']/parent::td//following-sibling::td[@class='unit-price']/span[text()='%s']/parent::td//following-sibling::td[@class='quantity']/span[text()='%s']/parent::td//following-sibling::td[@class='subtotal']/span[text()='%s']";
	public static final String WIST_LIST_LINK = "//span[@class='wishlist-label']";
	public static final String ADD_TO_CARD_CHECKBOX = "//input[@type='checkbox']";
	public static final String ADD_TO_CARD_BUTTON = "//button[contains(text(),'Add to cart')]";
	public static final String WIST_LIST_EMPTY_MESSAGE = "//div[@class='no-data']";
	public static final String HOME_PAGE_LINK = "//img[@alt='nopCommerce demo store']";
	public static final String REMOVE_BUTTON = "//button[@class='remove-btn']";

}
