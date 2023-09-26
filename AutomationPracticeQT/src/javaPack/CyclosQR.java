package javaPack;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CyclosQR extends CyclosBase{
	
	@Test
	public void QR() throws InterruptedException{
		driver.get("https://demo.cyclos.org/ui/banking/qr");
		assertTrue(driver.findElement(By.xpath("//a[@class='navbar-brand']qwq")).isDisplayed());
	
		//Enter UserName
		WebElement uName = driver.findElement(By.xpath("//input[@autocomplete='username']"));
		uName.sendKeys("demo");
		// Enter Password
		WebElement uPassword = driver.findElement(By.xpath("//input[@autocomplete='password']"));
		uPassword.sendKeys("1234");
		//Click Login
		driver.findElement(By.xpath("//action-button//button[@type='button']")).click();
	
		//Enter 10 in Amount
		driver.findElement(By.xpath("//input[@id='id_1']")).sendKeys("10");
		driver.findElement(By.xpath("//action-button[@class='d-inline-block button']")).click();
		
		Thread.sleep(2000);
		WebElement logout=driver.findElement(By.xpath("//a[@id='logout-trigger']"));
		
		//Click logout
		logout.click();
		

	}
	
}
