package eBankingTestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eBankingPageObjectModel.LoginPageFactory;
import eBankingUtilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	public static Logger logger = LogManager.getLogger(TC_LoginTest_001. class);
	
	@Test(dataProvider="LoginData")
	public void loginDDs(String username, String password) throws InterruptedException
	{
		LoginPageFactory lp = new LoginPageFactory(driver);
		lp.setUsername().sendKeys(username);
		logger.info("user name provided");
		lp.setPassword().sendKeys(password);
		logger.info("password provided");
		Thread.sleep(300);
		lp.submitButton().click();
		Thread.sleep(3000);
		
		//driver.quit();
		
		
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();   //close the alert
			driver.switchTo().defaultContent();   //driver back to initial window
			Assert.assertTrue(false);			//Login failed. Good login should not have alert.
			logger.warn("login has failed");
		}
		else 
		{
			Assert.assertTrue(true);  //i.e there is not alert after login i.e the login has passed
			Thread.sleep(3000);
			lp.submitButton().click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();  //close logout alert
			driver.switchTo().defaultContent();  //driver back to initial window
			logger.info("login has passed");
			
		}
		
		
		
		
		
		
		
		
	}
	
	private boolean isAlertPresent() {
		// TODO Auto-generated method stub
		return false;
	}
	
		
	
		
		
		

	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/eBankingProjectTestData/LoginData.xlsx";
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rowCount][colCount];
		
		for (int i=1; i<=rowCount; i++)
		{
			for (int j=0; j<colCount; j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
		
		
		
	}

}
