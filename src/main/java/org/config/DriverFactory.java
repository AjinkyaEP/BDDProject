package org.config;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverFactory
{

   private static DriverFactory instance;
   private static Logger logger; 
   private static WebDriver driver;
   
   private DriverFactory()
   {
	   
   }
   
   public static DriverFactory getInstance()
   {
	   if (instance==null)
			   instance = new DriverFactory();
      return instance;
   }

   public WebDriver getChromeDriver() 
   {
	   System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	   driver=new ChromeDriver();
	   return driver;
   }
   
   public Logger log() 
   {
	  String log4jConfigFile = "C:\\Users\\Ajinkya_Chudiwal\\eclipse-workspace\\Framework\\log4j.properties";
      PropertyConfigurator.configure(log4jConfigFile);
      return logger;
   }
}
