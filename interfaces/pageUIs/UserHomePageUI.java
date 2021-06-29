package pageUIs;

public class UserHomePageUI {
	// public : co the su trong o moi noi trong project
	// static : khong can phai new doi tuong, van co the su dung duoc
	// final : khong the gan lai trong qua trinh chay
	// static+final = hang so, ko thay doi duoc
	// String : vi trong abstractPage su dung locator kieu String
	// REGISTER_LINK : cu phap cua hang so trong java
	public static final String REGISTER_LINK = "//a[@class='ico-register']";
	public static final String LOGIN_LINK = "//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	public static final String PRODUCT_LINK = "	//a[contains(text(),'%s')]";
	public static final String DYNAMIC_IN_FOOTER_LINK = "//a[contains(text(),'%s')]";
	public static final String ADD_TO_COMPARE_LIST_LINK_BY_DYNAMIC_NAME ="//a[contains(text(),'%s')]/parent::h2//following-sibling::div[@class='add-info']/div[@class='buttons']/button[@title='Add to compare list']";
public static final String ADDED_PRODUCT_COMPARISON_MESSAGE ="//p[@class='content']";

}