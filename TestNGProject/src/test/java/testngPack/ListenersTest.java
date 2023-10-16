package testngPack;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(testngPack.MyListener.class)
public class ListenersTest {
	

	@Test
	void m1()
	{
		Assert.assertEquals(1, 1);
	}
	@Test
	void m2()
	{
		Assert.assertEquals(1, 2);
	}
	@Test(dependsOnMethods= {"m2"})
	void m3()
	{
		Assert.assertEquals(false, false);
	}

}
