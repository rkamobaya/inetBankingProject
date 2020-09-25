package eBankingTestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import eBankingUtilities.ReadConfig;

public class BaseClass {
	
	//things that are commons for every test case
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL = readConfig.getApplicationUrl();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	
	 
	//Whenever this setup method is executed before the class its launching the browser. Now we need to
	//launch the required browser (Chrome or IE or Firefox) based on the parameter which is passing from xml file.So to do this we have to 
	//take the parameter from xml file. So along with this before class annotation we can put another annotation (@Parameter) because this will
	//take parameter from xml file. So I will mention browser as variable.
	//After we modifier the baseClass, next thing I have to create a xml file at project level.
	
	@Parameters("browser")     //we have take parameter from xml file. The same variable name "browser" we have to use in the xml file
	@BeforeClass
	public void setup(String br)  //Now setup method has to take the same parameter. br is nothing but browser variable
								  //So I will the put the if else condition that will take the browser value that will pass in the xml file
	{
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readConfig.getChromeBrowser());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxBrowser());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readConfig.getInternetExplorerBrowser());
			driver = new InternetExplorerDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",readConfig.getEdgeBrowser());
			driver=new EdgeDriver();
		}

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(readConfig.getApplicationUrl());    //keep launch the application in the baseClass
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	
	
	
	@AfterClass
	public void tearDown()     
	{
	driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String testName) throws IOException {
		
		//To convert our WebDriver Object to TakesScreenshot. Since we writer our browser driver like WebDriver driver = new ChromeDriver();----> mean down cast our driver to TakesScreenhot.
		TakesScreenshot ts = (TakesScreenshot)driver;     //TakesScreenshot is an interface which help engineers to take screenshot. All the browser driver classes like 
													      //ChromeDriver, FirefoxDriver, InternetExplorerDriver, etc...implement TakesScreenshop interface.		        
														  
		//Capturing screenshot as output type file
		File source = ts.getScreenshotAs(OutputType.FILE);  //TakesScreenshot has a method name getScreenshotAs which can capture a screenshot and store it in different ways in specified locations
															//Virtual mode because we take the screenshot but its not present anyway in my system. 
															//I need to have that screenshot from source (virtual location) in my local system. source is a virtual location.
		
		//Whenever Selenium takes the screenshot we want Selenium to place the screenshot in this destinationPath
		//but 1st we need to convert that string path into File Format. 
		String destinationPath = (System.getProperty("user.dir") + "/Screenshots/" + testName +".png");
		
		//Convert String destinationPath into file format before we copy virtual file (source) into it				
	    File destPath = new File(destinationPath);  //we convert the
	    
		//copy the screenshot from the virtual file (source) in destination Path on our local location.
	    FileHandler.copy(source, destPath);       //FileUtils.copyFile(source, path);----> old utility not working well
	    
	    
		System.out.println("Screenshot taken");
		

		
		
	}
	
	
	
	
}
	
	


