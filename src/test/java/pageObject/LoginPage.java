package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage 
{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath ="//input[@name ='email']")
	WebElement eMailAddressInputTxt;
	
	@FindBy(xpath ="//input[@name ='password']")
	WebElement passwordInputTxt;
	
	@FindBy(xpath ="//input[@value= 'Login']")
	WebElement loginBtn;
	
	public void setEmailAddress(String emailAddress)
	{
		eMailAddressInputTxt.sendKeys(emailAddress);
	}
	
	public void setPassword(String password)
	{
		passwordInputTxt.sendKeys(password);
	}
	public void clickLoginBtn()
	{
		loginBtn.click();
	}
	
	//ssdpt@g.com
	//abcd
	
	
	
	
	

}
