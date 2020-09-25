package eBankingTestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Loader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import eBankingPageObjectModel.loginPage;

public class TC_LoginTest_001 extends BaseClass{
	
public static Logger logger = LogManager.getLogger(TC_LoginTest_001. class);		
	@Test
	public void credentiallogin() throws IOException
	{
		//driver.get("http://demo.guru99.com/V1/index.php");
		loginPage lp = new loginPage(driver);
		logger.info("Username is enterred");
		lp.usernameBox().sendKeys(username);
		logger.info("Password is enterred");
		
		lp.passwordBox().sendKeys(password);
		lp.submitButton().click();
		
		logger.info("This is the right title");
		
		logger.debug("To debug the code");
		
		logger.error("There is an error in the code");
		
		captureScreen(driver,"credentiallogin");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		String expectedTitle = "GTPL Bank Manager HomePage";
		
		
		Assert.assertEquals(expectedTitle, title);
		
	}

}
