package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class CyclosQR extends Driver{

	
	@Given("If user is on home page")
	public void if_user_is_on_home_page() throws Exception {
		Driver.LaunchBrowser();
		
		// Click login
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='login-link']")).click();
		//Login
		WebElement uName = driver.findElement(By.xpath("//input[@autocomplete='username']"));
		uName.sendKeys("demo");
		// Enter Password
		WebElement uPassword = driver.findElement(By.xpath("//input[@autocomplete='password']"));
		uPassword.sendKeys("1234");
		// Click Submit
		driver.findElement(By.xpath("//button[@type='button']//span")).click();
		// Verify Home link
		assertTrue(driver.findElement(By.xpath("//a[@id='menu_home']")).isDisplayed());
	}

	@When("User click on Banking link")
	public void user_click_on_banking_link() {
		driver.findElement(By.xpath("//a[@id='menu_banking']")).click();
	}

	@When("User click on Receive QR code")
	public void user_click_on_receive_qr_code() {
		driver.findElement(By.linkText("Receive QR-code")).click();
	}

	@When("Enter Amount")
	public void enter_amount() {
		driver.findElement(By.xpath("//input[@id='id_1']")).sendKeys("10");
		//driver.findElement(By.xpath("//input[@id='id_1']")).sendKeys("10", Keys.ENTER);
	}

	@When("user click on Generate QR Code")
	public void user_click_on_generate_qr_code() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//action-button[@class='d-inline-block button']")).click();
	}

	@Then("Verify QR code")
	public void verify_qr_code() throws Exception {
		Thread.sleep(1000);
		WebElement qrCode = driver.findElement(By.xpath("//receive-qr-payment-step-pending/div/img"));
		assertTrue(qrCode.isDisplayed());
		//Close the browser
		Driver.tearDown();
	}

}
