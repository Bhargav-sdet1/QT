package stepDefinitions;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import config.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
		excel=new ExcelUtils("C:\\Users\\bharg\\Selenium_Script_Sept2023\\Files\\LoginData.xlsx","Sheet1");
		uName.sendKeys(excel.getCellData(1, 0));
		// Enter Password
		WebElement uPassword = driver.findElement(By.xpath("//input[@autocomplete='password']"));
		uPassword.sendKeys(excel.getCellData(1, 1));
		// Click Submit
		driver.findElement(By.xpath("//button[@type='button']//span")).click();
	}

	@Then("Verify logout link")
	public void verify_logout_link() {
		WebElement logout = driver.findElement(By.xpath("//a[@id='logout-trigger']"));
		// Click logout
		boolean logoutStatus = logout.isDisplayed();
		assertTrue(logoutStatus);
		
		  if (logoutStatus == true)
			  logout.click();
		 
		//Close Browser
		  
		Driver.tearDown();
	}
}
