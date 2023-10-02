package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class CyclosQR {

	WebDriver driver;

	@Given("If user is on home page")
	public void if_user_is_on_home_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		// Load WebPage
		driver.get("https://demo.cyclos.org/ui/home");
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
	}

	@When("user click on Generate QR Code")
	public void user_click_on_generate_qr_code() {
		driver.findElement(By.xpath("//action-button[@class='d-inline-block button']")).click();
	}

	@Then("Verify QR code")
	public void verify_qr_code() {
		WebElement qrCode = driver.findElement(By.xpath("//receive-qr-payment-step-pending/div/img"));
		assertTrue(qrCode.isDisplayed());
		//Close the browser
		driver.quit();
	}

}
