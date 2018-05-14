package AutomationTests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Baseclass;
import ITProject2.AmazonProject.ObjectPage;
import Pageobjects.Loginpageobject;
import Pageobjects.Logoutpageobjects;
import Util.Appdataprovider;

public class LoginobjectTest extends Baseclass {
	
	Loginpageobject lp;
	Logoutpageobjects logout;
	ObjectPage page;
	
	@BeforeMethod
	public void launchBrowser()
	{
		setbrowser();
	//	lp = new Loginpageobject(driver);
	//	logout = new Logoutpageobjects(driver);
	}
	
	@AfterMethod
	public static void closebrowser() throws InterruptedException
	{
		quitbrowser(); 
		
	}
	
	/*//@Test
	
	public void validCredentialsTest()
	{
		lp.clickonthelogin();
		lp.enterusername("shaik.as400@gmail.com");
		lp.enterpassword("Abuhurayra1a@");
		lp.clickonbutton();
		
	}
	
	//@Test
	public void enterinvalidCredentialsTest()
	{
		lp.clickonthelogin();
		lp.enterusername("shaik.abc@gmail.com");
		lp.enterpassword("Abuhuraa1a@");
		lp.clickonbutton();
		logout.clickLogout(driver);
		System.out.println("logout succesfully");
	}
	
	//@Test
	public void enteronlyusername()
	{
		lp.clickonthelogin();
		lp.enterusername("shaikaltaf");
		lp.clickonbutton();
	}
	
	//@Test
	public void enteronlypassword()
	{
		lp.clickonthelogin();
		lp.enterpassword("abuhuid");
		lp.clickonbutton();
	}
	
	//@Test
	public void empptyUNandPW()
	{
		lp.clickonthelogin();
		lp.clickonbutton();
	}
	*/
	@Test(dataProvider = "LoginData",dataProviderClass = Appdataprovider.class)
	
	
	public void Loginpagetests(String Username,String pwd)
	{
		
		page = objectpages();
		page.loginpage(driver).clickonthelogin();
		page.loginpage(driver).enterusername(Username);
		page.loginpage(driver).enterpassword(pwd);
		page.loginpage(driver).clickonbutton();
		page.loginpage(driver).verifylogin();
		page.logoutpage(driver).clickLogout(driver);
		
		
		
	}
	
}



