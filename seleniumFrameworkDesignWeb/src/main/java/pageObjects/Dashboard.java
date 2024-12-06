package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.TechnicalComponents;

public class Dashboard extends TechnicalComponents{
	
WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

    @FindBy(css=".mb-3")
    List<WebElement> products;
    
    By productsName = By.cssSelector("b");
    
    By btn_AddToCart = By.cssSelector(".card-body button:last-of-type");
    
    
    public void selectProduct(String prodName) {
    	WebElement prod=products.stream().filter(product-> 
    	product.findElement(productsName).getText().equals(prodName)).findFirst().orElse(null);
    	prod.findElement(btn_AddToCart).click();
    	
    	
    }
	
//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//	
//	WebElement prod=products.stream().filter(product-> 
//	product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);	
//	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//    
//	WebElement prod=products.stream().filter(product-> 
//	product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);	
//	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	

}
