package testCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		try
		{
			logger.info("*****Starting Registration.....*****");
			//To access all the methods from home page we have to create an object
			HomePage hp = new HomePage(driver);
			logger.info("*****Clicked on My account Link*****");
			hp.clickMyAccount();
			logger.info("*****Clicked on Registration Link*****");
			hp.clickRegister();
				
			RegistrationPage rp = new RegistrationPage(driver);
			logger.info("*****Entering customer details in the Registration Link*****");
			rp.setFirstName(randomString().toUpperCase());
			rp.setLastName(randomString().toUpperCase());
			rp.setEmail(randomString()+"@gmail.com");
			rp.setTelephone(randomNumeric());
			
			String password = randomAlphaNumeric();
			rp.setPassword(password);
			rp.setConfirmPassword(password);
			rp.selectSubscribeoptnNo();
			rp.setPrivacyPolicy();
			rp.clickContinue();
			
			String cnfMsg = rp.getConfirmationMsg();
			logger.info("*****Validating the confirm message*****");
			Assert.assertEquals(cnfMsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.info("*****Registration failed*****");
			logger.debug("Debug Logs.......");
			Assert.fail();
		}
		
		logger.info("Registration completed successfully and confirmation message displayed");
	}
	
	

}
