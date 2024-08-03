package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_Loginddt extends BaseClass
{
	@Test(dataProvider = "LoginData" ,dataProviderClass = DataProviders.class,groups={"DataProvider","Master"})
	public void verify_LoginDDT(String email , String pwd , String expp)
	{
		try {
			
			//Home page
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin(); //Login link under MyAccount
					
				//Login page
				LoginPage lp=new LoginPage(driver);
				lp.setEmailAddress(email);
				lp.setPassword(pwd);
				lp.clickLoginBtn(); //Login button
					
				//My Account Page
				MyAccountPage macc=new MyAccountPage(driver);
				boolean targetPage=macc.isMyAccountDisplayed();
				
				if(expp.equalsIgnoreCase("Valid"))
				{
					if(targetPage==true)
					{
						macc.clickLogOut();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				
				if(expp.equalsIgnoreCase("Invalid"))
				{
					if(targetPage==true)
					{
						macc.clickLogOut();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
			}
			catch(Exception e)
			{
				Assert.fail("An exception occurred: " + e.getMessage());
			}
				
			logger.info("**** Finished TC_003_LoginDDT *****");
		}
		
	}
    

