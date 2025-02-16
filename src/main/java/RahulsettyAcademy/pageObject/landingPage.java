package RahulsettyAcademy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.abstractComponent;

public class landingPage extends abstractComponent
{
	
	WebDriver driver;
	
	@FindBy(id="userEmail")
	WebElement userName;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement getMessage;
	
	public landingPage(WebDriver driver)
	{
		super(driver);
			this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public productCatalogue logInApplication(String username,String pass)
	{
		userName.sendKeys(username);
		password.sendKeys(pass);
		submit.click();
		 productCatalogue productcatalogue=new productCatalogue(driver);
         return productcatalogue;
	}
	
	public void goTO()
	{
		 driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() 
	 {
		 waitaforWebElementToAppear(getMessage);
		 return getMessage.getText();
	 }

	 
	

}
