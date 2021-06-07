package commons;
//khi viet ham can chu y 5 van de : 

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

//1.ham duoc su dung co chuc nang gi,
//2.tham so truyen vao la gi
//3. neu co tham so truyen vao thi define bien dai dien cho gia tri cua tham so
//4.kieu tra ve cua ham trong == kieu tra ve cua ham ngoai
//5.neu co tra ve thi can return

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
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

	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		element.click();

	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = getElement(driver, locator);
		element.clear();
		element.sendKeys(value);

	}

	// dropdown basic
	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
		WebElement element = getElement(driver, locator);
		Select select = new Select(element);
		select.selectByVisibleText(itemValue);

	}

	public String getFirstSelectedItemInDropdown(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();

	}

	public Boolean IsDropdownMultiple(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		Select select = new Select(element);
		return select.isMultiple();

	}

	// dropdown custom
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		// 1.click vao 1 the bat ki de xo ra het cac item trong dropdown
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		// 2. cho cho tat ca cac item co trong HTML DOM( ko can visible)
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
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
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
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

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		WebElement element = getElement(driver, locator);
		return element.getAttribute(attributeName);

	}

	public String getElementText(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		return element.getText();

	}

	public int countElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();

	}

	public void checkToCheckBox(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void uncheckToCheckBox(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();

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
}
