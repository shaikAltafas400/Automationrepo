package ITProject2.AmazonProject;

import org.openqa.selenium.WebDriver;

import Pageobjects.Loginpageobject;
import Pageobjects.Logoutpageobjects;

public class ObjectPage {
	
	WebDriver driver;

	public ObjectPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public Loginpageobject loginpage(WebDriver driver) 
	{
		return new Loginpageobject(driver);
		
		
	}

	public Logoutpageobjects logoutpage(WebDriver driver) 
	{
		return new Logoutpageobjects(driver);
		
		
	}
	
}
