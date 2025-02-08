package reusableComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.TestSetup;

public class TechnicalComponents extends TestSetup{
	

	WebDriverWait wait= new WebDriverWait(getDriver(),Duration.ofSeconds(5));

	public void waitTill(WebElement element, String waitType) throws Exception {
		switch (waitType.toLowerCase()) {
		case "visible":
		    wait.until(ExpectedConditions.visibilityOf(element));
		    break;
		case "invisible":
			wait.until(ExpectedConditions.invisibilityOf(element));
			break;
		default:
			throw new Exception("wait not configured");
		    
		}
	}

}
