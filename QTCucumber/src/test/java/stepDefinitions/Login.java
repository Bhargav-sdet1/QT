package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class Login {
	
	WebDriver driver;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		// Load WebPage
		driver.get("https://demo.cyclos.org/ui/home");
		// Verify Home link
		assertTrue(driver.findElement(By.xpath("//a[@id='menu_home']")).isDisplayed());
	}

	@When("User click on login link")
	public void user_clik_on_login_link() throws Exception {
		// Click login
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='login-link']")).click();  
	}

	@When("User enters valid Uname and Password")
	public void user_enters_valid_uname_and_password() {
		WebElement uName = driver.findElement(By.xpath("//input[@autocomplete='username']"));
		uName.sendKeys("demo");
		// Enter Password
		WebElement uPassword = driver.findElement(By.xpath("//input[@autocomplete='password']"));
		uPassword.sendKeys("1234");
		// Click Submit
		driver.findElement(By.xpath("//button[@type='button']//span")).click();
	}

	@Then("Verify logout link")
	public void verify_logout_link() {
		WebElement logout = driver.findElement(By.xpath("//a[@id='logout-trigger']"));
		// Click logout
		boolean logoutStatus = logout.isDisplayed();
		assertTrue(logoutStatus);
		/*
		 * if (logoutStatus == true) logout.click();
		 */
		//Close Browser
		driver.quit();
	}
}
