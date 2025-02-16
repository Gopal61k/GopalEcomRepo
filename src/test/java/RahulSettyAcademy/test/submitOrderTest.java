package RahulSettyAcademy.test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RahulsettyAademy.Component.BaseClass;
import RahulsettyAcademy.pageObject.ConfirmationPage;
import RahulsettyAcademy.pageObject.OrderPage;
import RahulsettyAcademy.pageObject.cartPage;
import RahulsettyAcademy.pageObject.checkoutpage;
import RahulsettyAcademy.pageObject.landingPage;
import RahulsettyAcademy.pageObject.productCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class submitOrderTest extends BaseClass
{
	 String productName="ZARA COAT 3";	 
 
	@Test(dataProvider = "getData" )
	public void submitOrder(String email,String pass,String productName) throws IOException
	{
		 
	   
	 productCatalogue productcatalogue=landingpage.logInApplication(email,pass);
	 List<WebElement> products= productcatalogue.getProductList();
	 productcatalogue.addPrductToCart(productName);
	 cartPage cartpage= productcatalogue.goTocartpage(); 
	 boolean match = cartpage.VerifyProductDisplay(productName);
	 Assert.assertTrue(match);
	 checkoutpage checkoutpage=cartpage.goTOcheckout();
	 checkoutpage.selectCountry("india");
	 ConfirmationPage confirmationpage=checkoutpage.submitOrder();
	 String confirmmessage =confirmationpage.getConformationMessage();
	 Assert.assertTrue(confirmmessage.equalsIgnoreCase("Thankyou for the order."));	 
	 
	}
	
	@Test(dependsOnMethods = "submitOrder")
	public void OrderHistory()
	{
		 productCatalogue productcatalogue=landingpage.logInApplication("gopal0011@gmail.com", "Gopal@1122");
		 OrderPage orderpage = productcatalogue.goToOrderpage();
		 Assert.assertTrue(orderpage.VerifyOrderDisplay(productName));
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		return new Object [][]  {{"gopal0011@gmail.com","Gopal@1122","ZARA COAT 3"},{"gopal0011@gmail.com","Gopal@1122","ZARA COAT 3"}};
				
	}
	
	

}
