package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myaccounthdr;
	
	@FindBy(xpath ="//div[@class='list-group']//a[text()='Logout']")
	WebElement logoutbtn;
	
	public Boolean isMyAccountDisplayed()
	{
		
		try 
		{
			 return (myaccounthdr.isDisplayed());
		} 
		catch (Exception e) {
			
			return false;
		}
		
	}
	
	public  void clickLogOut()
    {
		logoutbtn.click();
	}
	
	

}
