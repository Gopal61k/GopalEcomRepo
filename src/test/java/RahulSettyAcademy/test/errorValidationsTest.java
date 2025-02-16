package RahulSettyAcademy.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import RahulsettyAademy.Component.BaseClass;
import RahulsettyAcademy.pageObject.cartPage;
import RahulsettyAcademy.pageObject.productCatalogue;

 

public class errorValidationsTest extends BaseClass
{
	
	@Test(groups = {"errorhandling"})
	public void logInErrorValidation()
	{
		  	 
		landingpage.logInApplication("gopal0011@gmail.comm", "Gopal@1122");
		assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	}
	
	@Test
	public void productErrorValidation() throws IOException
	{
		 String productName="ZARA COAT 3";	
	  
	productCatalogue productcatalogue=landingpage.logInApplication("gopal0011@gmail.com", "Gopal@1122");
	 
	List<WebElement> products= productcatalogue.getProductList();
	 productcatalogue.addPrductToCart(productName);
	 cartPage cartpage= productcatalogue.goTocartpage(); 
	
	 boolean match = cartpage.VerifyProductDisplay(productName);
	 Assert.assertTrue(match);
	 
	  

		 
	 
	}

}
