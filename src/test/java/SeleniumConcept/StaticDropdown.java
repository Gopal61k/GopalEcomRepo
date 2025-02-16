package SeleniumConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class StaticDropdown {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Asus\\Desktop\\desktop\\browser\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		//select check box
		Assert.assertFalse(driver.findElement(By.xpath(" //input[@name='ctl00$mainContent$chk_SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.xpath(" //input[@name='ctl00$mainContent$chk_SeniorCitizenDiscount']")).click();
		 Assert.assertTrue(driver.findElement(By.xpath(" //input[@name='ctl00$mainContent$chk_SeniorCitizenDiscount']")).isSelected());

		//size of check box
		 
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
		 
		
		WebElement staticDropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
   
		Select sc=new Select(staticDropdown);
		sc.selectByIndex(3);
		System.out.println(sc.getFirstSelectedOption().getText());
		
		sc.selectByVisibleText("INR");
		System.out.println(sc.getFirstSelectedOption().getText());
		sc.selectByValue("AED");
		System.out.println(sc.getFirstSelectedOption().getText());
		 
		
		
	}

}
