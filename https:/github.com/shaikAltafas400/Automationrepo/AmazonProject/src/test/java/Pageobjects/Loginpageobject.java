package Pageobjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpageobject {
	
	@FindBy(xpath = "//span[@class='nav-line-1'][contains(text(),'Hello. Sign in')]") private WebElement login;
	@FindBy(xpath = "//input[@type='email']") private WebElement userName;
	@FindBy(xpath = "//input[@type='password']") private WebElement passWord;
	@FindBy(xpath = "//input[@id='signInSubmit']") private WebElement submitButton;
	@FindBy(xpath="//span[@class='nav-line-1' and text()='Hello, Altaf']") public WebElement success;
	@FindBy(xpath="//span[@class='nav-line-1' and text()='Hello, Altaf']") public WebElement logout;


	public Loginpageobject(WebDriver driver)

	{
		PageFactory.initElements(driver, this);
	}

	public void clickonthelogin()
	{
		login.click();
	}
	
	public void enterusername(String username)
	{
		userName.sendKeys("shaikaltafas400@gmail.com");
	}
	
	public void enterpassword(String password)
	{
		passWord.sendKeys("Abuhurayra1a@");
	}
	
	public void clickonbutton()
	{
		submitButton.click();
	}
			
	public void verifylogin()
	{
		assertTrue(success.isDisplayed());
		
	}
	
	public void verifylogout()
	{
		assertTrue(logout.isDisplayed());
	}
	
}
