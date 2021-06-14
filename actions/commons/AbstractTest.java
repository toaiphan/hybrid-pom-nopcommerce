package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class AbstractTest {

	private WebDriver driver;
	private String projectFolder = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");

	protected WebDriver getBrowserDriver(String browserName) {
		setBrowserDriver();
		if (browserName.equals("firefox_ui")) {
			// set geko driver

			// khoi tao driver
			driver = new FirefoxDriver();

		} else if (browserName.equals("chrome_ui")) {
			// set geko driver

			// khoi tao driver
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox_headless")) {
			// set geko driver

			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);

		} else if (browserName.equals("chrome_headless")) {
			// set geko driver

			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("windown-size=1920x1080");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("edge_chromium")) {
			// set geko driver

			// khoi tao driver
			driver = new EdgeDriver();

		} else {

			throw new RuntimeException("Please input valid browser name value");
		}

		// khoi tao implicit wait 30s
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

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
}
