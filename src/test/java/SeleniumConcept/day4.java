package SeleniumConcept;

import org.testng.annotations.Test;

public class day4 
{
	@Test(enabled=true)
	public void mobileSignInCar()
	{
		System.out.println("Mobile SIgnIn");
	}
	
	@Test(dependsOnMethods= {"mobileSignInCar"})
	public void mobileSignoutCar()
	{
		System.out.println("Mobile SIgnout");
	}
	
	@Test(enabled=true)
	public void apiCarLoan()
	{
		System.out.println("API loan car");
	}
	
	@Test (timeOut=1000)
	public void apiBikeLoan() throws InterruptedException
	{
		Thread.sleep(1500);
		System.out.println("API bike loan");
	}

}
