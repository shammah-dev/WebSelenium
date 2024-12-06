package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.TechnicalComponents;
import reusableComponents.TestSetup;

public class HomePage extends TechnicalComponents{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement btn_Submit;
	
	
	public void enterUserDetails(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
	}
	
	public void clickSubmit() {
		btn_Submit.click();
	}

}
