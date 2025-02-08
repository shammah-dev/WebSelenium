package practiceFramework;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestToGetAllLinksOfPage {
	
	
	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();

	
	
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
	int size=driver.findElements(By.tagName("a")).size();
	System.out.println(size);
	
	WebElement footer=driver.findElement(By.id("gf-BIG"));
	int footerSize=footer.findElements(By.tagName("a")).size();
	System.out.println(footerSize);
	
//	driver.get("https://www.icc-cricket.com/tournaments/t20cricketworldcup/matches");
//	String date="\"29 June, 2024\"";
//	WebElement name=driver.findElement(By.xpath("//h3[contains(text(),"+date+")]//ancestor::div[@class='si-tab-card-section']//div[contains(@class,'si-team si-team')]//h3//span[1]"));
//	
//	String text = name.getText();
//	System.out.println(text);
	//h3[contains(text(),'29 June, 2024')]//ancestor::div[@class='si-tab-card-section']//div[contains(@class,'si-team si-team')]//h3//span[1]
	driver.close();
	
	
	}

}
