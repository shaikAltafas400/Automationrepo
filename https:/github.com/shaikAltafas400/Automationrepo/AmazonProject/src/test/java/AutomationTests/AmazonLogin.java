package AutomationTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Baseclass;

public class AmazonLogin extends Baseclass{

	@BeforeMethod
	public void launchBrowser()
	{
		setbrowser();
	}
	
	@AfterMethod
	public static void quitbrowser()
	{
		quitbrowser();
		
	}
	
	@Test
	
	public void testlogin()
	{
		getWebelement(AppElements.getProperty("Signin")).click();
		getWebelement(AppElements.getProperty("userid")).sendKeys("shaik.as400@gmail.com");
		getWebelement(AppElements.getProperty("password")).sendKeys("Abuhurayra1a@");
		getWebelement(AppElements.getProperty("Loginbutton")).submit();

	}
}
