package stepDefinitions;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pagesPOM.LoginOR;

public class Login extends Driver{
	
	LoginOR loginOr;
	ExcelUtils excel;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		
		Driver.LaunchBrowser();
		// Load WebPage
		driver.get(url);
		loginOr = new LoginOR(driver);
		// Verify Home link
		assertTrue(loginOr.HomeIcon.isDisplayed());
	}

	@When("User click on login link")
	public void user_clik_on_login_link() throws Exception {
		// Click login
		Thread.sleep(2000);
		loginOr.loginlink.click();  
	}

	@When("User enters valid {string} and {string}")
	public void user_enters_valid_and(String UName, String UPassword) {
	    loginOr.fillLogin(UName, UPassword);
	}
	@When("User enters valid Uname and Password")
	public void user_enters_valid_uname_and_password() throws Exception {
		WebElement uName = driver.findElement(By.xpath("//input[@autocomplete='username']"));
		excel=new ExcelUtils("","Sheet1");
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
		Driver.tearDown();
	}
}
