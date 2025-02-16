package SeleniumConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class updatedDropdown {

	public static void main(String[] args) throws InterruptedException  
	{ 
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Asus\\Desktop\\desktop\\browser\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("divpaxinfo")).click();
      Thread.sleep(2000);
	
		 for(int i=1;i<5;i++)
		{
		driver.findElement(By.id("hrefIncAdt")).click();
        i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
	}

}
