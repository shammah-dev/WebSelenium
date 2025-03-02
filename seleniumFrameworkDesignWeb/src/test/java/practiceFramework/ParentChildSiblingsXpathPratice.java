package practiceFramework;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentChildSiblingsXpathPratice {
	
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.icc-cricket.com/fixtures-results");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h3[text()='17 January, 2025']//parent::div[@id='card-section1']//h3[@class='si-team-name']//span[1]")));
		List<WebElement> teams= driver.findElements(By.xpath("//h3[text()='17 January, 2025']//parent::div[@id='card-section1']//h3[@class='si-team-name']//span[1]"));	
		for (WebElement team:teams) {
			System.out.println(team.getText());
		}
		driver.close();
		
		
		
	}

}
