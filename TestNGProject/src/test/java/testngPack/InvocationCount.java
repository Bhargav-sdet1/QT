package testngPack;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InvocationCount {
	WebDriver driver;
	
	@Test(invocationCount=5)
	void Test() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='login_form_username']")).sendKeys("nov9@yopmail.com");
		driver.findElement(By.xpath("//input[@id='login_form_password']")).sendKeys("Asdfg1@34");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
	}
	
	@BeforeClass
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.get("https://muse.goarya.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterClass
	public void tearDown()
	{
	driver.quit();	
	}
	

}
