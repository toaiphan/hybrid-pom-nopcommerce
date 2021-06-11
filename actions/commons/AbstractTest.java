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

	protected WebDriver getBrowserDriver(String browserName) {

		if (browserName.equals("firefox_ui")) {
			// set geko driver

			System.setProperty("webdriver.gecko.driver", projectFolder + "/browserDriver/geckodriver.exe");
			// khoi tao driver
			driver = new FirefoxDriver();

		} else if (browserName.equals("chrome_ui")) {
			// set geko driver

			System.setProperty("webdriver.chrome.driver", projectFolder + "/browserDriver/chromedriver.exe");
			// khoi tao driver
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox_headless")) {
			// set geko driver

			System.setProperty("webdriver.gecko.driver", projectFolder + "/browserDriver/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);

		} else if (browserName.equals("chrome_headless")) {
			// set geko driver

			System.setProperty("webdriver.chrome.driver", projectFolder + "/browserDriver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("windown-size=1920x1080");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("edge_chromium")) {
			// set geko driver

			System.setProperty("webdriver.edge.driver", projectFolder + "/browserDriver/msedgedriver.exe");
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

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);

	}
}
