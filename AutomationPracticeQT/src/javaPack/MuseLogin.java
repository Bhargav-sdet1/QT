package javaPack;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MuseLogin {
	WebDriver driver;

	@Test
	public void museLogin() throws InterruptedException {
		driver.get("https://muse.goarya.com/");
		assertTrue(driver.findElement(By.cssSelector(".please-log-into-your-copy")).isDisplayed());
		// Enter UserEmail
		WebElement Email = driver.findElement(By.xpath("//input[@name='username']"));
		Email.clear();
		Email.sendKeys("nov9@yopmail.com");
		String enteredEmail = Email.getText();

		// Enter Password
		WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
		Password.sendKeys("Asdfg1@34");
		String enteredPassword = Email.getText();
		// Click Login
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		assertTrue(driver.findElement(By.xpath("//img[@class='headerprofilepic']")).isDisplayed());
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@class='headerprofilepic']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='logout-class']")).click();

	}

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// @AfterTest
	public void tearDown() {
		driver.close();
	}

}
