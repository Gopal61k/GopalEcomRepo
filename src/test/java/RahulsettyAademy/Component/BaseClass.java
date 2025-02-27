package RahulsettyAademy.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.j2objc.annotations.Property;

import RahulsettyAcademy.pageObject.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{ 
	public WebDriver driver;
	public  landingPage landingpage;
	public WebDriver initializeDriver() throws IOException
	{
	Properties prop=new Properties();
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Rahulsettyacdemy//resourses//GlobalData.properties");
	prop.load(file);
	String browserName=prop.getProperty("browser");
	
	if(browserName.equalsIgnoreCase("chrome"))
	{

		 WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("forefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
	}
	else if(browserName.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
	}
	driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 return driver;
	}
	
	public List<HashMap<String, String>> getjsonDataReaderToMap(String filepath) throws IOException  
	{
 		String jsonContent = FileUtils.readFileToString(new File(filepath));
	
	 ObjectMapper mapper=new ObjectMapper();
	 List<HashMap<String,String>> data= mapper.readValue(jsonContent, new com.fasterxml.jackson.core.type.TypeReference<List<HashMap<String,String>>> (){
	});
	 return data;
	 
	 
	}
	
	
	
	@BeforeMethod
	public landingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		  landingpage=new landingPage(driver);
		 landingpage.goTO();
		 return landingpage;
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
 	 

}
