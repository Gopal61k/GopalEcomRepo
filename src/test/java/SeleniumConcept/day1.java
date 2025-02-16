package SeleniumConcept;

import org.testng.annotations.Test;

public class day1 
{
	@Test
	public void Demo()
	{
		System.out.println("Hello");
	}

	@Test(groups={"smoke"})
	public void secondTest()
	{
		System.out.println("day1: By");
	}
}
