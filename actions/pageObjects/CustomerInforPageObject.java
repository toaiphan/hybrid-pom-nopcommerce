package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class CustomerInforPageObject extends AbstractPage {
	WebDriver driver;

	// ham khoi tao ( contructor), khi new class nay len thi no se chay dau tien
		// cung ten voi ten class
		// gan driver toan cuc cho cuc bo
	// matching driver cho nhieu class
		// chi can new 1 lan driver , nhung class khac gan lai
		public CustomerInforPageObject(WebDriver driver) {

			this.driver = driver;
		} 


}