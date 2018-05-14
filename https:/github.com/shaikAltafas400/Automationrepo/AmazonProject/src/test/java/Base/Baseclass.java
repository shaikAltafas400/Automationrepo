package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import ITProject2.AmazonProject.ObjectPage;
import Util.ExcelProvider;

public class Baseclass {

	public static WebDriver driver = null;
	public static Properties AppData = null;
	public static Properties AppElements = null;
	public static FileInputStream Fis= null;
	public static ExcelProvider xls = null;
	
	
	
	
	@BeforeClass
	
	public void Initialisation() throws IOException
	{
		Fis = new FileInputStream(System.getProperty("user.dir")+ "/src/test/Resources/AppData.properties");
		AppData = new Properties();
		AppData.load(Fis);
	

		Fis = new FileInputStream(System.getProperty("user.dir")+ "/src/test/Resources/AppElements.properties");
		AppElements = new Properties();
		AppElements.load(Fis);	
		xls = new ExcelProvider(System.getProperty("user.dir")+"/src/test/Resources/TestExcel.xlsx");
	}
	
	public static void setbrowser()
	{
		if(AppData.getProperty("Browser").toUpperCase().equalsIgnoreCase("BROWSER"));
		{
			System.setProperty("webdriver.chrome.driver", "/Users/altafmacbook/Eclipse/AmazonProject/Drivers/chromedriver");
			driver = new ChromeDriver();
			driver.get(AppData.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
	}
	
	public static WebElement getWebelement(String element)
	{
		try{
			WebElement xpathelement = driver.findElement(By.xpath(element));
			return xpathelement;
		}
		catch(Exception e)  
		{
			System.out.println("element not found " + element);
			return null;

		}	
	}
	
	public ObjectPage  objectpages()
	{
		
		return new ObjectPage(driver);
		
		
	}
	
	public static void quitbrowser() throws InterruptedException 
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
}