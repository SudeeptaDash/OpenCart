package testCase;

import java.lang.System.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass
{
    @Test(groups={"Sanity","Master"})
    public void verifyLogin()
    {
    	try {
			logger.info("*************Started Login Test***************");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("*************Clicked on My account***************");
			hp.clickLogin();
			logger.info("*************Clicked on Login***************");
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAddress(p.getProperty("EmailAddress")); 
			lp.setPassword(p.getProperty("password"));
			logger.info("*************Entered user nameand password***************");
			lp.clickLoginBtn();
			logger.info("*************Page Submitted***************");
			
			MyAccountPage myaccp = new MyAccountPage(driver);
			Assert.assertTrue(myaccp.isMyAccountDisplayed());
		}
    	catch (Exception e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    

}
