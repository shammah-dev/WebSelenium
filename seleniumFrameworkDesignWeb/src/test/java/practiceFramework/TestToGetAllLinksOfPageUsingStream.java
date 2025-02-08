package practiceFramework;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestToGetAllLinksOfPageUsingStream{
	
	
	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
	List<WebElement> links=driver.findElements(By.tagName("a"));
	for(WebElement s: links) {
		System.out.println(s.getAttribute("href"));	
	}
	
	long a=links.stream().filter(s->s.getAttribute("href").contains("AutomationPractice")).count();
	System.out.println(a);
//	WebElement source= driver.findElement(By.xpath("//ul[@class='navigation clearfix']"));
//	WebElement Des=driver.findElement(By.xpath("//div[@class='price-title']"));
//	
//	Actions ac= new Actions(driver);
//	ac.moveToElement(Des).perform();
//	
//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
//	
//	
//	WebElement course= driver.findElement(By.xpath("//a[text()='VIEW ALL COURSES']"));
	
//	Map<String,Object> param=new HashMap<>();
//	param.put("direction", "down");
//	param.put("element", course);
//	
//	((JavascriptExecutor) driver).executeScript("mobile:scroll", param);
//	
//     driver.close();
//     
//     
//     TouchActions act=new TouchActions(driver);
//     act.longPress(longPressOptions.withElement(element(course))).withDuration(ofSeconds(2)).moveTo(element(links)).release().perform();
//	
     
     
//     ac.scrollToElement(course);
//     ac.moveToElement(course).perform();
	driver.close();
	
	}

}
