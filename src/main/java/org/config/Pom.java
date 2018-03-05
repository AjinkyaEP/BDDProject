/*******************************************************************************************************************************************
 OBJECTIVE:- This is a config class which provides configuration parameters and methods which to be intialized to start automation test
 AUTHOR:- Ajinkya Chudiwal	
 EMAIL:-ajinkya_chudiwal@epam.com
 DATE:- 05/03/2018
 *******************************************************************************************************************************************/
package org.config;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pom 
{
	private static String url="http://www.cleartrip.com/";
	private static String chromeDriverPath="./src/main/resources/chromedriver.exe";
	private static String logFilePath="./log4j.properties";
	private static Logger logger;
	public WebDriver driver=null;
	
	//This method assists in initializing Web driver. 
	public void intializeDriver()
	{
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get(url);
	}
	
	//This method assists in quitting the driver. 
	public void quitDriver()
	{
		driver.quit();
	}
	
	//This method assists in initializing log utility.
	public static Logger log() 
	{
		String log4jConfigFile = logFilePath;
	    PropertyConfigurator.configure(log4jConfigFile);
	    return logger;
	}
}
