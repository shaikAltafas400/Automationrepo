package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logoutpageobjects {

	 @FindBy(xpath="//span[text()='your Orders']") private WebElement yourOrders;
	 @FindBy(xpath="//span[text()='your Orders']") private WebElement signOut;

	 public Logoutpageobjects(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void clickLogout(WebDriver driver)
	 {
		 Actions a = new Actions(driver);
		 
		 a.moveToElement(yourOrders).pause(2000).click(signOut);
	 }
}
