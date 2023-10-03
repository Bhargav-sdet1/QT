package stepDefinitions;

import io.cucumber.java.*;

public class Hooks {
	@Before
	public void beforeScenario()
	{
		System.out.println("Before Scenario");
	}
	@After
	public void afterScenario()
	{
		System.out.println("After QR");
	}
	@Before("@QR")
	public void beforeScenario1()
	{
		System.out.println("Before QR");
	}
	@After("QR")
	public void afterScenario1()
	{
		System.out.println("After QR");	
	}
}
