package javaPack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookPractice {

	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	public void fetchMonths()
	{
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		WebElement monthDD=driver.findElement(By.xpath("//select[@aria-label='Month']"));
		
		monthDD.click();
		System.out.println(monthDD.getText());

	}	
	@Test
	public void selectMonth() throws InterruptedException
	{
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		WebElement yearDD=driver.findElement(By.xpath("//select[@aria-label='Year']"));
		
		Select select = new Select(yearDD);
		String year = "1947";
		yearDD.click();
		//List<WebElement> years=select.getOptions();
		if(yearDD.getText().contains(year))
		{
			select.selectByValue(year);
			Thread.sleep(2000);
		}

	}
	
	//@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
