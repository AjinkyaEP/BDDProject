package org.config;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Pom 
{
	public static DriverFactory DF=DriverFactory.getInstance();
	public static WebDriver driver=DF.getChromeDriver();
	public static String url="http://www.cleartrip.com/";
	public static Logger logger=DF.log();	
}
