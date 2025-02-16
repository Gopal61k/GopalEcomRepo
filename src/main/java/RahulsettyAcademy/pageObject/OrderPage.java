package RahulsettyAcademy.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class OrderPage extends abstractComponent

{
	WebDriver driver;

	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productnames; 
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver,this);	  
	}
	public Boolean VerifyOrderDisplay(String ProductName)
	{
		Boolean match=productnames.stream().anyMatch(product->product.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	 
}
