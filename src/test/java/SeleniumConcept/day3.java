package SeleniumConcept;

import org.testng.annotations.Test;

public class day3 
{
	@Test 
	public void Aswift()
	{
		System.out.println("swift dezir");
	}
	@Test (groups= {"smoke"})
	public void bpunch()
	{
		System.out.println("punch car");
	}
	
	@Test (groups= {"smoke"})
	public void bbpunch()
	{
		System.out.println("punch car1");
	}
	
	@Test(priority = -1)
	public void cvista()
	{
		System.out.println("vista car");
	}
	
	@Test(priority = 0)
	public void suzuki()
	{
		System.out.println("maruti suzuki");
	}
	
	@Test (priority=-3)
	public void dgrandvista()
	{
		System.out.println("maruti suzuki-3");
	}
	

}
