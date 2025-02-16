package RahulSettyAcademy.test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class standalonetest 
{
	static String productname="BANARSI SAREE";
	public static void main(String[] args)  
	{
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 driver.get("https://rahulshettyacademy.com/client");

	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.findElement(By.id("userEmail")).sendKeys("gopal0011@gmail.com");
	 driver.findElement(By.id("userPassword")).sendKeys("Gopal@1122"); //gopal0011@gmail.com","Gopal@1122
	 driver.findElement(By.id("login")).click();
	
	 
	 
	 
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	 List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
	WebElement prod= products.stream().filter(product1->product1.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
  
 	 prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
 
 
 
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

//click to cart button
driver.findElement(By.cssSelector("[routerlink*='cart']")).click();


//added cart history
List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));

  boolean match = cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
  Assert.assertTrue(match);
  //click on check button
  driver.findElement(By.cssSelector(".totalRow button")).click();
  
//select contry
  Actions act=new Actions(driver);
  
 act.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
 
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results ")));
 
 driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
 
 //click to place order button
 
 driver.findElement(By.cssSelector(".action__submit")).click();
 
 // validate place order text
 
 String confirmmessage = driver.findElement(By.cssSelector(".hero-primary")).getText();

 Assert.assertTrue(confirmmessage.equalsIgnoreCase("Thankyou for the order."));
 
	 
	}

}
