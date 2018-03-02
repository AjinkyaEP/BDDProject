package org.config;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pom 
{
	public static DriverFactory DF=DriverFactory.getInstance();
	public static String url="http://www.cleartrip.com/";
	public static String chromeDriverPath="./src/main/resources/chromedriver.exe";
	public static Logger logger=DF.log();		
	public WebDriver driver=null;
	
	public void intializeDriver()
	{
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get(Pom.url);
	}
	
	public void quitDriver()
	{
		driver.quit();
	}
	
}
