package javaPack;

import org.testng.annotations.Test;

public class TestNGDemo {

	@Test(priority=1)
	void openApp()
	{
		System.out.println("Launch application");
	}
	
	@Test(priority=2)
	void login()
	{
		System.out.println("Login...");
	}
	
	@Test(priority=3)
	void logout()
	{
		System.out.println("Logout...");
	}
}
