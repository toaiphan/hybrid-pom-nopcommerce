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

}
