package pageUIs;

public class AdminProductPageUI {
	public static final String PAGING_AT_TABLE_BY_INDEX = "//li[@class='paginate_button page-item ']/a[text()='%s']";
	public static final String PAGING_AT_TABLE_ACTIVE_BY_INDEX = "//li[@class='paginate_button page-item active']/a[text()='%s']";

	public static final String SELECT_ALL_CHECKBOX = "//th/input[@class='mastercheckbox']";
	public static final String ALL_PRODUCT_CHECKBOX = "//input[@class='checkboxGroups']";
	public static final String PRODUCT_CHECKBOX_BY_NAME = "//td[text()='%s']/preceding-sibling::td/input";
	public static final String PRODUCT_DETAIL_IN_TABLE = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/i[contains(@class,'%s-icon')]";


}
