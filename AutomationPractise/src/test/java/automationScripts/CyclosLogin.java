package automationScripts;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import base.CyclosBase;

public class CyclosLogin extends CyclosBase{
	

	@Test
	public void login()
	{
		driver.findElement(By.xpath("//a[@id='login-link']")).click();
		driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("demo");
	}
}
