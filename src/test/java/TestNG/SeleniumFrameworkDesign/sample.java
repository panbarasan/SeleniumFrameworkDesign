package TestNG.SeleniumFrameworkDesign;

import org.testng.annotations.Test;

public class sample {
	
	int a;
	
	public int value()
	{
		a=10;
		
		return a;
	}
	
	
	
	@Test
	public void m1()
	{
		System.out.println(value());
	}

}
