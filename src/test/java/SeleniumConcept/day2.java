package SeleniumConcept;

import org.testng.annotations.Test;

public class day2
{
	@Test
	public void loan()
	{
		System.out.println("personal loan");
	}

	@Test(groups= {"smoke"})
	public void carloan()
	{
		System.out.println("car loan");
	}
}
