package config;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSetup {
	
	//static WebDriver driver;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); 
	 
		 
	
	@BeforeClass
	@Parameters({"browserName"})
	public void beforeClass(String browserName) throws Exception {
		if(Utilities.getProperty("execution").equalsIgnoreCase("remote")) {
			driver.set(OpenBrowser(browserName));	
		}else {
		browserName= Utilities.getProperty("browserName");
		driver.set(OpenBrowser(browserName));
		}
	}
	
	 public static WebDriver getDriver() {
			return driver.get();
		}
	
	public static WebDriver OpenBrowser(String BrowserName) throws Exception {
	DesiredCapabilities caps = new DesiredCapabilities();
	WebDriver localDriver=null;
	switch(BrowserName.toLowerCase()) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		localDriver =new ChromeDriver();
		localDriver.manage().window().maximize();
		localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		localDriver =new FirefoxDriver();
		localDriver.manage().window().maximize();
		localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		break;
	case "edge":
		WebDriverManager.edgedriver().setup();
		localDriver =new  EdgeDriver();
		localDriver.manage().window().maximize();
		localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	case "remotechrome":
		caps.setBrowserName("chrome");
		localDriver = new RemoteWebDriver(new URL("http://10.0.0.100:4444"),caps);
		localDriver.manage().window().maximize();
		localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		break;
	case "remotefirefox":
		caps.setBrowserName("firefox");
		localDriver = new RemoteWebDriver(new URL("http://10.0.0.100:4444"),caps);
		localDriver.manage().window().maximize();
		localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		break;
	case "default":
		throw new Exception("Browser not configured.");

	}
	return localDriver;
	
	
	}
	
	@AfterClass
	public  void afterClass() {
		getDriver().close();
	}
}
