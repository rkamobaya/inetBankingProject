package eBankingUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("C:\\Users\\rkamo\\eclipse-workspace\\eBankingProject\\Configuration\\config.properties");
		
			try { 
				FileInputStream fis = new FileInputStream(src);
				pro = new Properties();
				pro.load(fis);
			    }
		catch(Exception e)
		{
		System.out.println("Exception is" + e.getMessage());
		}
	}
	
	public String getUsername()
	{
		String userid = pro.getProperty("username");
		return userid;
	}
	
	public String getPassword()
	{
		String passw = pro.getProperty("password");
		return passw;
	}
	
	public String getApplicationUrl()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getChromeBrowser()
	{
		String chrome = pro.getProperty("chromePath");
		return chrome;
	}
	
	public String getFirefoxBrowser()
	{
		String firefox = pro.getProperty("firefoxPath");
		return firefox;
	}
	
	public String getInternetExplorerBrowser()
	{
		String ie = pro.getProperty("iePath");
		return ie;
	}
	
	public String getEdgeBrowser()
	{
		String edge = pro.getProperty("edgePath");
		return edge;
	}

}
