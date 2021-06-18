package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {

	private WebDriver driver;
	private String projectFolder = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");
	protected final Log log;

	protected AbstractTest() {

		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName) {
		// C1 de chay multi os
		// setBrowserDriver();
		// C2 :Dung WebDriverManager (
		Browser browser = Browser.valueOf(browserName.toUpperCase());

		if (browser == Browser.FIREFOX_UI) {
			// set geko driver

			// WebDriverManager ( thu vien cua JAva): tu dong tai driver , tu dong set
			// WebDriverManager.firefoxdriver().driverVersion("xxxxx").setup();( setup
			// version, neu khong se tu tai ver moi nhat)
// hoac browserVersion("xxxxx")
			// Property
			WebDriverManager.firefoxdriver().setup();

			// khoi tao driver
			driver = new FirefoxDriver();

		} else if (browser == Browser.CHROME_UI) {
			// set geko driver
			WebDriverManager.chromedriver().setup();
			// khoi tao driver
			driver = new ChromeDriver();

		} else if (browser == Browser.FIREFOX_HEADLESS) {
			// set geko driver
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);

		} else if (browser == Browser.CHROME_HEADLESS) {
			// set geko driver
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("windown-size=1920x1080");
			driver = new ChromeDriver(options);

		} else if (browser == Browser.EDGE_CHROMIUM) {
			// set geko driver
			WebDriverManager.edgedriver().setup();

			// khoi tao driver
			driver = new EdgeDriver();

		} else {

			throw new RuntimeException("Please input valid browser name value");
		}

		// khoi tao implicit wait GlobalConstants.LONG_TIMEOUTs
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String url) {
		// C1 de chay multi os
		// setBrowserDriver();
		// C2 :Dung WebDriverManager (
		Browser browser = Browser.valueOf(browserName.toUpperCase());

		if (browser == Browser.FIREFOX_UI) {
			// set geko driver

			// WebDriverManager ( thu vien cua JAva): tu dong tai driver , tu dong set
			// WebDriverManager.firefoxdriver().driverVersion("xxxxx").setup();( setup
			// version, neu khong se tu tai ver moi nhat)
// hoac browserVersion("xxxxx")
			// Property
			WebDriverManager.firefoxdriver().setup();

			// khoi tao driver
			driver = new FirefoxDriver();

		} else if (browser == Browser.CHROME_UI) {
			// set geko driver
			WebDriverManager.chromedriver().setup();
			// khoi tao driver
			driver = new ChromeDriver();

		} else if (browser == Browser.FIREFOX_HEADLESS) {
			// set geko driver
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);

		} else if (browser == Browser.CHROME_HEADLESS) {
			// set geko driver
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("windown-size=1920x1080");
			driver = new ChromeDriver(options);

		} else if (browser == Browser.EDGE_CHROMIUM) {
			// set geko driver
			WebDriverManager.edgedriver().setup();

			// khoi tao driver
			driver = new EdgeDriver();

		} else {

			throw new RuntimeException("Please input valid browser name value");
		}

		// khoi tao implicit wait GlobalConstants.LONG_TIMEOUTs
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);

		return driver;
	}

///multi OS ------------------------------ CACH 1--------------------------------
	private void setBrowserDriver() {
		if (isWindows()) {
			System.setProperty("webdriver.chrome.driver",
					projectFolder + getDirectorySlash("browserDriver") + "chromedriver.exe");
			System.setProperty("webdriver.gecko.driver",
					projectFolder + getDirectorySlash("browserDriver") + "geckodriver.exe");
			System.setProperty("webdriver.edge.driver",
					projectFolder + getDirectorySlash("browserDriver") + "msedgedriver.exe");

		} else if (isMac()) {
//tren MAC can phai set permistion
			System.setProperty("webdriver.chrome.driver",
					projectFolder + getDirectorySlash("browserDriver") + "chromedriver.mac");
			System.setProperty("webdriver.gecko.driver",
					projectFolder + getDirectorySlash("browserDriver") + "geckodriver.mac");
			System.setProperty("webdriver.edge.driver",
					projectFolder + getDirectorySlash("browserDriver") + "msedgedriver.mac");
		} else {
			System.setProperty("webdriver.chrome.driver",
					projectFolder + getDirectorySlash("browserDriver") + "chromedriver.linux");
			System.setProperty("webdriver.gecko.driver",
					projectFolder + getDirectorySlash("browserDriver") + "geckodriver.linux");

		}

	}
//-----------------------------------Multi OS CACH 2----------------------------//
//WebDriverManager ( thu vien cua JAva): tu dong tai driver , tu dong set Property
	// https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
	// tai version moi + tat ca Compile Dependencies
	// copy vao libWebDriverManager = >Add to build path tat ca file

	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);

	}

	private String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else if (isWindows()) {
			folderName = "\\" + folderName + "\\";
		} else {
			folderName = null;
		}
		return folderName;
	}

	private boolean isWindows() {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	private boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	private boolean isUnix() {
		return (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0);
	}

	private boolean isSolaris() {
		return (osName.toLowerCase().indexOf("sunos") >= 0);
	}

	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
