package RahulsettyAcademy.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponent.abstractComponent;

public class productCatalogue extends abstractComponent
{

	WebDriver driver;
	
	public productCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
 
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
 
	
	public List<WebElement> getProductList()
	{
		waitForElementToApper(productBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod= products.stream().filter(product1->product1.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
 	 return prod;
	}
	
	
	public void addPrductToCart(String productName)
	{
		
		WebElement prod=getProductByName(productName);
		 prod.findElement(addToCart).click();
		 waitForElementToApper(toastMessage);
		 waitElementToDisappear(spinner);	
	}
}
