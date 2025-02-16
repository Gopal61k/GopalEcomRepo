package RahulsettyAcademy.pageObject;

import javax.security.auth.callback.ConfirmationCallback;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class checkoutpage extends abstractComponent
{
    WebDriver driver;
	public checkoutpage(WebDriver driver) {
		super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectcountry;
	
	By results=By.cssSelector(".ta-results");
	
	 public  void selectCountry(String countryName)
	 {
		 Actions a=new Actions(driver);
		 a.sendKeys(country,countryName).build().perform();
		 
		 waitForElementToApper(By.cssSelector(".ta-results"));
		 selectcountry.click();
	 }
	 public ConfirmationPage submitOrder()
	 {
		 submit.click();
		 return new ConfirmationPage(driver);
		  
		 
		 
	 }
	

}
