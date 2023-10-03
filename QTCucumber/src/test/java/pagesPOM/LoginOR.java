package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOR {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@id='menu_home']") public WebElement HomeIcon;
	@FindBy(xpath=("//a[@id='login-link']")) public WebElement loginlink;	
	@FindBy(xpath="//input[@autocomplete='username']")public WebElement uName;
	@FindBy(xpath="//input[@autocomplete='password']") public WebElement uPassword;
	@FindBy(xpath="//button[@type='button']//span")public WebElement loginSubmit;
	
	public LoginOR(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void fillLogin(String UName,String Password)
	{
		uName.sendKeys(UName);
		uPassword.sendKeys(Password);
		loginSubmit.click();
	}
	
	

}
