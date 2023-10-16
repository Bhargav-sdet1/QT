package testngPack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	WebDriver driver;
	
	@BeforeClass
	void setUp()
	{
		driver= new ChromeDriver();
		driver.get("https://muse.goarya.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(dataProvider="dp")
	void login(String Email, String Password) throws InterruptedException
	{
		Thread.sleep(3000);
		// Enter UName
		WebElement UEmail = driver.findElement(By.xpath("//input[@name='username']"));
		UEmail.sendKeys(Email);
		// Enter Password
		WebElement uPassword = driver.findElement(By.xpath("//input[@name='password']"));
		uPassword.sendKeys(Password);
		// Click Submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		boolean homeicon=driver.findElement(By.xpath("//li[@role='menuitem']//a")).isDisplayed();
		Assert.assertTrue(homeicon);
	}
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider(name="dp")
	Object[][] LoginData()
	{
	
		Object data[][]= {
				{"nov9@yopmail.com","Asdfg1@34"},
				{"ak99@yopmail.com","Asdfg1@34"},
				{"asghgf","12345"}		
		};
		return data;
	}
}
