package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;

public class BaseClass 
{
	
	
	public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups={"Sanity","Regression","Master","DataProvider"})
	@Parameters({"browser","os"})
	public void setup(String br,String os ) throws Exception
	{
		logger = LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		    case "chrome" : driver = new ChromeDriver(); break;
		    case "edge" : driver = new EdgeDriver(); break;
		    case "firefox" : driver = new FirefoxDriver(); break;
		    default : System.out.println("Invalid Browser"); return;
		}
		
		FileReader file = new FileReader (".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		
	}
	@AfterClass(groups={"Sanity","Regression","Master","DataProvider"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	public String randomNumeric()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	public String randomAlphaNumeric()
	{
		String generatedAlphaNumeric = RandomStringUtils.randomAlphanumeric(9);
		return generatedAlphaNumeric;
	}
	public String captureScreen(String tname) throws IOException 
	{
        Date d = new Date(0);
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(d);
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	

}
