/***********************************************************************************************************
 OBJECTIVE:- This is a utility class which provides utility methods which is required to support automation
 AUTHOR:- Ajinkya Chudiwal	
 EMAIL:-ajinkya_chudiwal@epam.com
 DATE:- 05/03/2018
 ***********************************************************************************************************/
package org.config;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pom 
{
	private static String url="http://www.cleartrip.com/";
	private static String chromeDriverPath="./src/main/resources/chromedriver.exe";
	private static String logFilePath="./log4j.properties";
	private static String testDataFileName="./src/main/resources/data.json";
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
	
	//Read Data from JSON file
	public String readData(String scenarioName, String parameter)
	{
		File file = new File(testDataFileName);
	    String content = null;
		try 
		{
			content = FileUtils.readFileToString(file, "utf-8");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		JSONObject obj = new JSONObject(content);	
		JSONObject scenarioObject = obj.getJSONObject(scenarioName);
		String value = scenarioObject.getString(parameter);
		return value;
	}
}
