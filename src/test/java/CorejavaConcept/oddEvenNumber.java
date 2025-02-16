package CorejavaConcept;

import java.util.ArrayList;

public class oddEvenNumber 
{
	public static void main(String args[])
	{
		int a[]= {1,2,3,4,5,6,7,8,6,8};
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]%2==0)
			{
				System.out.println("This is even number : "+a[i]);
			}
			else
			{
				System.out.println("This is odd number :"+a[i]);
			}
		}
		
		//ArrayList
		ArrayList<String> aa=new ArrayList<String>();
		aa.add("core java");
		aa.add("selenium");
		aa.add("automation");
		aa.add("TestNG");
		aa.remove(2);
		System.out.println(aa); //[core java, selenium, TestNG]
		System.out.print(aa.get(1)); //selenium
	
	}

}
