package RahulSettyAcademy.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RahulsettyAademy.Component.BaseClass;
import RahulsettyAcademy.pageObject.ConfirmationPage;
import RahulsettyAcademy.pageObject.OrderPage;
import RahulsettyAcademy.pageObject.cartPage;
import RahulsettyAcademy.pageObject.checkoutpage;
import RahulsettyAcademy.pageObject.productCatalogue;
import junit.framework.Assert;

public class submitOrdernew extends BaseClass
{
	
	 
	@Test(dataProvider = "getData" )
	public void submitOrder(HashMap<String,String> input) throws IOException
	{
		 
	   
	 productCatalogue productcatalogue=landingpage.logInApplication(input.get("email"),input.get("password"));
	 List<WebElement> products= productcatalogue.getProductList();
	 productcatalogue.addPrductToCart(input.get("product"));
	 cartPage cartpage= productcatalogue.goTocartpage(); 
	 boolean match = cartpage.VerifyProductDisplay(input.get("product"));
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
		String productName="ZARA COAT 3";	 
		 productCatalogue productcatalogue=landingpage.logInApplication("gopal0011@gmail.com", "Gopal@1122");
		 OrderPage orderpage = productcatalogue.goToOrderpage();
		 Assert.assertTrue(orderpage.VerifyOrderDisplay("product"));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String, String> map=new HashMap<String,String>();
//		map.put("email","gopal0011@gmail.com");
//		map.put("password", "Gopal@1122");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String, String> map1=new HashMap<String,String>();
//		map1.put("email","gopal0011@gmail.com");
//		map1.put("password", "Gopal@1122");
//		map1.put("product", "ZARA COAT 3");
//		
//		
		List<HashMap<String, String>> data = getjsonDataReaderToMap(System.getProperty("user.dir")+"//src//test//java//GopalData//purchaseOrder.json");
		return new Object [][]  {{data.get(0)},{data.get(1)}};
				
	}
	
	

}
