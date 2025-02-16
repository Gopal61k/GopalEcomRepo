package SeleniumConcept;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day5 
{
	
	@Test(dataProvider = "getData")
	public void loginPage(String id,String password)
	{
		System.out.println(id);
		System.out.println(password);
	}

	
	 @DataProvider
	public Object[][] getData()
	{
		 Object[][] a=new Object[3][2];
		 
		 a[0][0]="gopa";
		 a[0][1]="karhale";
		 
		 a[1][0]="rajendra";
		 a[1][1]="patil";
		 
		 a[1][0]="Balaji";
		 a[1][1]="kadam";
		  return a;
		 
				 
		 
		 
		 
		 
	}
}
