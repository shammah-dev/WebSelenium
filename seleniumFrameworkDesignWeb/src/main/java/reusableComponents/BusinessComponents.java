package reusableComponents;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;

public class BusinessComponents extends TechnicalComponents{
	
	
	public static void navigateTo(String url) {
		getDriver().get(url);
	}

	public static void loginOnHomePage() {
	HomePage home = new HomePage(getDriver());
	home.enterUserDetails("rahulsheety456@mailinator.com", "Test12345");
	home.clickSubmit();
	}

}
