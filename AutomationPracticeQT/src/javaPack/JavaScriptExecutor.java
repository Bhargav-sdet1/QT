package javaPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		
		WebElement login=driver.findElement(By.xpath("//button[@name='login']"));
		WebElement email=driver.findElement(By.xpath("//input[@type='text']"));
		WebElement pwd=driver.findElement(By.xpath("//input[@type='password']"));
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", login);
		
		//js.executeScript("document.getElementById('login').value='Selenium'");
		
	}

}
