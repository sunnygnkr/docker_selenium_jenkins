package BaseTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestPage {

protected WebDriver driver;
	
	@BeforeTest
	public void driverSetup() throws MalformedURLException {
		
//		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
//		driver=new ChromeDriver();
		
		String host = "localhost";
		DesiredCapabilities capabilities =new DesiredCapabilities();
		
		
		if(System.getProperty("BROWSER")  != null &&
				System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			FirefoxOptions ffOptions = new FirefoxOptions();
			capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, ffOptions);
		}else {
			ChromeOptions chrOptions = new ChromeOptions();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chrOptions);
		}
		
		if(System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}
		
		String completeURL = "http://"+  host +":4444/wd/hub";
		this.driver = new RemoteWebDriver(new URL(completeURL), capabilities);
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
}
