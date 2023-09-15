package javaPack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseActions {
	
	WebDriver driver;
	
	@Test
	public void cssSelector() throws InterruptedException
	{
		driver.get("https://retail.onlinesbi.sbi/");
		
		Actions act = new Actions(driver);
		Thread.sleep(5000);
		act.moveToElement(driver.findElement(By.xpath("//ul[@id='primary_navigation']/li[10]/a"))).perform();
		Thread.sleep(5000);
		act.moveToElement(driver.findElement(By.xpath("//ul[@id='primary_navigation']/li[10]/a/following-sibling::ul/li[2]"))).perform();
		Thread.sleep(5000);
		driver.findElement(By.linkText("MCA Current Account")).click();
		
		Thread.sleep(2000);
		
	}
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
