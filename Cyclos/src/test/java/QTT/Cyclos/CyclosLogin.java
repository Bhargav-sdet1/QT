package QTT.Cyclos;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CyclosLogin {

	WebDriver driver;

	@Test(priority=1)
	public void cssSelector() throws InterruptedException, IOException {
		// Load WebPage
		driver.get("https://demo.cyclos.org/ui/home");
		// Verify Home link
		assertTrue(driver.findElement(By.xpath("//a[@id='menu_home']")).isDisplayed());

		// Click login
		driver.findElement(By.xpath("//a[@id='login-link']")).click();
		// Enter UName
		WebElement uName = driver.findElement(By.xpath("//input[@autocomplete='username']"));
		uName.sendKeys("demo");
		// Enter Password
		WebElement uPassword = driver.findElement(By.xpath("//input[@autocomplete='password']"));
		uPassword.sendKeys("1234");

		// Click Submit
		driver.findElement(By.xpath("//button[@type='button']//span")).click();

		WebElement logout = driver.findElement(By.xpath("//a[@id='logout-trigger']"));
		// Click logout
		boolean logoutStatus = logout.isDisplayed();
		if (logoutStatus == true)
			logout.click();
	}
	
	@Test(priority=2)
	public void validateUrl()
	{	
		Assert.assertEquals(driver.getCurrentUrl(), "Home - Cyclos");		
	}
	@Test(priority=3,dependsOnMethods= {"validateUrl"})
	public void validateTitle()
	{	
		Assert.assertEquals(driver.getTitle(), "Home - Cyclos");		
	}

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}

	@AfterTest
	public void tearDown() throws IOException {
		driver.close();
	}

}
