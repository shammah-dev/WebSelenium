package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.TestSetup;
import reusableComponents.TechnicalComponents;

public class HomePage extends TechnicalComponents{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement btn_Submit;
	
	@FindBy(id="login")
	List<WebElement> btn_Done;
	
	
	public void enterUserDetails(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
	}
	
	public void clickSubmit() {
		btn_Submit.click();
	}

}
