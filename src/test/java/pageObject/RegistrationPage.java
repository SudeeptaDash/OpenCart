package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage
{

	public RegistrationPage(WebDriver driver) 
	{
		super(driver);
	
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value=1]")
	WebElement chkSubscribeYes;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value=0]")
	WebElement chkSubscribeNo;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkAgree;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement msgConformation;
	
	public void setFirstName(String firstName)
	{
		txtFirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName)
	{
		txtLastName.sendKeys(lastName);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		txtTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	public void setConfirmPassword(String cnfirmpassword)
	{
		txtConfirmPassword.sendKeys(cnfirmpassword);
	}
	public void selectSubscribeoptnYes()
	{
		chkSubscribeYes.click();
	}
	public void selectSubscribeoptnNo()
	{
		chkSubscribeNo.click();
	}
	public void setPrivacyPolicy()
	{
		chkAgree.click();
	}
	public void clickContinue() {
		//sol1 
		btnContinue.click();
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
	}

	public String getConfirmationMsg() {
		try {
			return (msgConformation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}

}
