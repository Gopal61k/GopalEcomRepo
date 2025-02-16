package SeleniumConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseOverAction 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Asus\\Desktop\\desktop\\browser\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
		driver.get("https://amazon.com");
		
		//object of Action class
		Actions act=new Actions(driver);
		
		act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("one plus mobile").build().perform();
		
		act.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		act.moveToElement(driver.findElement(By.id("nav_prefetch_yourorders"))).click().build().perform();
		
		
		
		
	}

}
