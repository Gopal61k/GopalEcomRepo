package SeleniumConcept;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupBrowser
{
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Asus\\Desktop\\desktop\\browser\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
		driver.get("https://rahulshettyacademy.com/client");
	System.out.println(driver.getTitle());
   System.out.println(driver.getCurrentUrl());	
	driver.close();
	
	
	}

}
