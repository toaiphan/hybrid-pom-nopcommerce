package commons;
//khi viet ham can chu y 5 van de : 

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//chi su dung cho testcase, ko cho before va after
//1.ham duoc su dung co chuc nang gi,
//2.tham so truyen vao la gi
//3. neu co tham so truyen vao thi define bien dai dien cho gia tri cua tham so
//4.kieu tra ve cua ham trong == kieu tra ve cua ham ngoai
//5.neu co tra ve thi can return

//CACH SU DUNG : 
//C1: khai bao , khoi tao 1 doi tuong abstractPage, sau do su dung abstractPage de  su dung cac ham
//C2:extends vao class can su dung, sau do su dung cac ham duoi ( toi gian code hon C1)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.PageGeneratorManager;
import pageObjects.UserSearchPagePO;
import pageUIs.AbstractPageUI;
import pageUIs.UserHomePageUI;

//trong nay se viet tat cac cac ham common, de su dung lai
public class AbstractPage {

	// ham de mo PageUrl
	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);

	}

	// ham lay ra currentPageUrl
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	// ham lay ra currentPageTitle
	public String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();

	}

	// ham lay ra currentPageSource
	public String getCurrentPageSource(WebDriver driver) {
		return driver.getPageSource();

	}

	// ham back
	public void backToPage(WebDriver driver) {
		driver.navigate().back();

	}

	// ham forward
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();

	}

	// ham F5
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();

	}

	// cac ham lien quan den alert
	// accept alert
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// accept alert
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// gettext
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	// settext
	public void setTextAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	// waitAlertPresence
	public void waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	// ham cho phan window

	// ham switch chi dung cho truong hop 2 tab/2window
	public void switchToWindowByID(WebDriver driver, String parentID) {

		// lay tat ca id cua cac cua so
		Set<String> allWindows = driver.getWindowHandles();
		// neu id nao khac voi parent thi nhay qua window do
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
			//

		}
	}
	// neu can swich co nhieu tab : can dung ham title :1h20p topic 21

	public void switchToWindowByTitle(WebDriver driver, String pageTitle) {
		// lay ra tat ca id cua window/tab dang co
		Set<String> allWindows = driver.getWindowHandles();

		// dung for de duyet qua tung window/tab
		for (String runWindows : allWindows) {

			driver.switchTo().window(runWindows);
			// lay ra title cua tab
			String currentPageTitle = driver.getTitle();
			// kiemn tra title cua page nao bang title mong muon
			if (currentPageTitle.equals(pageTitle)) {
				break;

			}

		}
	}

	public boolean areAllTabCloseWithoutParent(WebDriver driver, String parentID) {
		// lay tat ca id cua cac cua so
		Set<String> allWindows = driver.getWindowHandles();
		// neu id nao khac voi parent thi nhay qua window do
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();

			}
		}
		driver.switchTo().window(parentID);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	// cac ham cho element

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));

	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));

	}

	public By getByXpath(String locator) {
		return By.xpath(locator);

	}

	public String getDynamicLocator(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;

	}

	public void clickToElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		element.click();

	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		element = getElement(driver, getDynamicLocator(locator, values));
		element.click();

	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		element = getElement(driver, locator);
		element.clear();

		// do chrome va edge hay co loi khi clear xong ma sendkeys nhanh qua , nen can
		// wait 500 milisecond
		if (driver.toString().toLowerCase().contains("chrome") || driver.toString().toLowerCase().contains("edge")) {
			sleepInMiliSecond(500);

		}
		element.sendKeys(value);

	}

	public void sendKeyToElement(WebDriver driver, String locator, String value, String... values) {
		element = getElement(driver, getDynamicLocator(locator, values));
		element.clear();

		// do chrome va edge hay co loi khi clear xong ma sendkeys nhanh qua , nen can
		// wait 500 milisecond
		if (driver.toString().toLowerCase().contains("chrome") || driver.toString().toLowerCase().contains("edge")) {
			sleepInMiliSecond(500);

		}
		element.sendKeys(value);

	}

	// dropdown basic
	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
		element = getElement(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(itemValue);

	}

	public String getFirstSelectedItemInDropdown(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();

	}

	public Boolean IsDropdownMultiple(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.isMultiple();

	}

	// dropdown custom
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		// 1.click vao 1 the bat ki de xo ra het cac item trong dropdown
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		// 2. cho cho tat ca cac item co trong HTML DOM( ko can visible)
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));
		// 3. lay het tat ca cac item nay dua vao 1 list element
		List<WebElement> allItems = getElements(driver, childItemLocator);
		// 4. duyet qua tung item
		for (WebElement item : allItems) {
			// 5. moi lan duyet qua kiem tra xem text cua item do co bang voi item minh can
			// click hay khong
			String actualItem = item.getText();
			// neu nhu ma bang thi thoat khoi khong duyet nua
			// neu nhu khong bang thi duyet tiep cho den het tat ca item
			if (actualItem.equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				// truoc khi click thi scroll den element
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(2);
				// wait cho element click able
				explicitWait.until(ExpectedConditions.elementToBeClickable(item));
				item.click();
				sleepInSecond(2);
				break;
			}
		}

	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void sleepInMiliSecond(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		element = getElement(driver, locator);
		return element.getAttribute(attributeName);

	}

	public String getElementText(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.getText();

	}

	public String getElementText(WebDriver driver, String locator, String... values) {
		element = getElement(driver, getDynamicLocator(locator, values));
		return element.getText();

	}

	public int countElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();

	}

	public int countElementSize(WebDriver driver, String locator, String... values) {
		return getElements(driver, getDynamicLocator(locator, values)).size();

	}

	public void checkToCheckBox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void checkToCheckBox(WebDriver driver, String locator, String... values) {
		element = getElement(driver, getDynamicLocator(locator, values));
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void uncheckToCheckBox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();

	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		return getElement(driver, getDynamicLocator(locator, values)).isDisplayed();

	}

	public boolean isElementEnable(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();

	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();

	}

	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));

	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();

	}
	// user interaction

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();

	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();

	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();

	}

	public void clickAndHoldToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.clickAndHold(getElement(driver, locator)).perform();

	}

	public void drapAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();

	}

	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();

	}

	// JS executor

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
		sleepInSecond(1);
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getElement(driver, locator));
	}

//	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
//		explicitWait = new WebDriverWait(driver, timeout);
//		jsExecutor = (JavascriptExecutor) driver;
//
//		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
//			@Override
//			public Boolean apply(WebDriver driver) {
//				try {
//					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
//				} catch (Exception e) {
//					return true;
//				}
//			}
//		};
//
//		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
//			@Override
//			public Boolean apply(WebDriver driver) {
//				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
//			}
//		};
//
//		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
//	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		// chieu rong chieu cac lon>0
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	// wait

	public void waitToElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitToElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait
				.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}

	public void waitToElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		overideImplicitWait(driver, GlobalConstants.SHORT_TIMEOUT);
		System.out.print("Start time = " + new Date().toString());

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
		System.out.print("End time = " + new Date().toString());

		overideImplicitWait(driver, GlobalConstants.LONG_TIMEOUT);

	}

	public void waitToElementInvisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait
				.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}

	public void waitToElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));

	}

	public void waitToElementClickable(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));

	}

// neu 10-15 page thi co the lam cach nay
	public AbstractPage openLinkByPageName(WebDriver driver, String pageName) {
		waitToElementClickable(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		switch (pageName) {
		case "Addresses":
			return PageGeneratorManager.getUserAddressesPage(driver);
		case "My Product Reviews":
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInfoPage(driver);
		default:
			return PageGeneratorManager.getUserOdersPage(driver);

		}
	}

//neu nhieu page qua thi dung cach nay
	public void openLinkWithPageName(WebDriver driver, String pageName) {
		waitToElementClickable(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);

	}
	public void clickToLinkInFooterbyName(WebDriver driver,String linkNameInFooter) {
		waitToElementClickable(driver, AbstractPageUI.DYNAMIC_IN_FOOTER_LINK, linkNameInFooter);
		clickToElement(driver, AbstractPageUI.DYNAMIC_IN_FOOTER_LINK, linkNameInFooter);

	}
	

	public void waitAjaxLoadingInvisible(WebDriver driver) {
		waitToElementInvisible(driver, AbstractPageUI.LOADING_ICON);

	}

	public void uploadFileByPanelID(WebDriver driver, String panelID, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FOLDER;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";

		}
		fullFileName = fullFileName.trim();
		sendKeyToElement(driver, AbstractPageUI.UPLOAD_FILE_TYPE_BY_PANEL, fullFileName, panelID);
	}

	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		System.out.print("Start time = " + new Date().toString());
		overideImplicitWait(driver, GlobalConstants.SHORT_TIMEOUT);
		elements = getElements(driver, locator);
		overideImplicitWait(driver, GlobalConstants.LONG_TIMEOUT);
		if (elements.size() == 0) {
			System.out.print("Element ko hien thi tren UI va khong co trong DOM");
			System.out.print("End time = " + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.print("Element ko hien thi tren UI va co trong DOM");
			System.out.print("End time = " + new Date().toString());
			return true;

		} else {
			System.out.print("Element co tren UI va co trong DOM");

			return false;
		}
	}

	public void overideImplicitWait(WebDriver driver, long timeInSecond) {
		driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
	}

	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	private WebElement element;
	private Actions action;
	private List<WebElement> elements;
	private Select select;
}
