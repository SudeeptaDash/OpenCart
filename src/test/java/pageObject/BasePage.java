package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage 
{
	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);  
		// Mandatory helps to invoke driverr instance in page factory methods
	}
}
