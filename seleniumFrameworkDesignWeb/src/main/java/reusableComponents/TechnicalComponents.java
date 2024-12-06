package reusableComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TechnicalComponents extends TestSetup{
	
	
	WebDriver driver;
	
	public TechnicalComponents(WebDriver driver) {
		this.driver=driver;
	}

	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));

	public void waitTill(WebElement element, String waitType) {
		switch (waitType.toLowerCase()) {
		case "visible":
		    wait.until(ExpectedConditions.visibilityOf(element));
		    break;
		case "invisible":
			wait.until(ExpectedConditions.invisibilityOf(element));
		    
		}
	}

}
