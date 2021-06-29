package pageUIs;

public class UserCheckOutPageUI {

	public static final String COUNTRY_DROPDOWN = "//select[@id='BillingNewAddress_CountryId']";

	public static final String STATE_DROPDOWN = "//select[@id='BillingNewAddress_StateProvinceId']";
	public static final String CITY_TEXTBOX = "//input[@id='BillingNewAddress_City']";
	public static final String ADDRESS1_TEXTBOX = "//input[@id='BillingNewAddress_Address1']";
	public static final String ZIPCODE_TEXTBOX = "//input[@id='BillingNewAddress_ZipPostalCode']";
	public static final String PHONE_NUMBER_TEXTBOX = "//input[@id='BillingNewAddress_PhoneNumber']";
	public static final String GROUND_SHIP_METHOD_RADIO_BUTTON = "//input[@id='shippingoption_0']";
	public static final String SHIP_CONTINUE_BUTTON = "//div[@id='shipping-method-buttons-container']//button[@type='button'][contains(text(),'Continue')]";
	public static final String CHECK_MONEY_ORDER_PAYMENT_METHOD = "//input[@id='paymentmethod_0']";
	public static final String PAYMENT_CONTINUE_BUTTON = "//div[@id='payment-method-buttons-container']//button[@type='button'][contains(text(),'Continue')]";
	public static final String PAYMENT_INFORMATION_TEXT = "//p[contains(text(),'Mail Personal or Busine')]";
	public static final String CONTINUE = "//div[@id='payment-info-buttons-container']//button[@type='button'][contains(text(),'Continue')]";
public static final String PAYMENT_METHOD_TEXT ="//span[contains(text(),'Check / Money Order')]";
public static final String SHIPPING_METHOD_TEXT ="//span[@class='value'][contains(text(),'Ground')]";
public static final String WRAPPER_TEXT = "//div[@class='selected-checkout-attributes']";
public static final String PRODUCT_DETAIL_IN_TABLE = " //a[text()='%s']//parent::td//following-sibling::td/span[text()='%s']//parent::td//following-sibling::td/input[@value='%s']//parent::td//following-sibling::td/span[text()='%s']";
public static final String TOTAL_TEXT = "//tr[@class='order-total']//td[@class='cart-total-left']//label[contains(text(),'Total:')]/parent::td//following-sibling::td//strong";

public static final String CONFIRM_BUTTON ="//button[contains(text(),'Confirm')]";
public static final String ORDER_SUCCESS_MESSAGE = "//strong[contains(text(),'Your order has been successfully processed!')]";
public static final String SHIP_TO_SAME_ADDRESS_CHECKBOX = "//input[@id='ShipToSameAddress']";

}
