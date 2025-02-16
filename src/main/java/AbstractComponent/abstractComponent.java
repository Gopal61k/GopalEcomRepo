package AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import RahulsettyAcademy.pageObject.OrderPage;
import RahulsettyAcademy.pageObject.cartPage;

public class abstractComponent 
{
	WebDriver driver;
	public abstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[routerlink*='cart']")
    WebElement cartHeader;
	@FindBy(xpath=" //button[@routerlink=\"/dashboard/myorders\"]")
	WebElement OrderHeader;
	public   OrderPage goToOrderpage()  
	{
		 
		OrderHeader.click();
		OrderPage orderpage=new OrderPage(driver);
		 return orderpage;
	}
	
	public cartPage goTocartpage()  
	{
		 
		cartHeader.click();
		cartPage cartpage=new cartPage(driver);
		 return cartpage;
	}
	
	public void waitForElementToApper(By findBy)
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	     wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));	
	}
	
	public void waitElementToDisappear(WebElement ele)
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void waitforwebElementToappear(WebElement findBy)
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitaforWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

}
