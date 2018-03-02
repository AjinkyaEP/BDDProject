package org.config;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverFactory
{

   private static DriverFactory instance;
   private static Logger logger; 
   
   private DriverFactory()
   {

   }
   
   public static DriverFactory getInstance()
   { 
	   if (instance==null)
		   instance = new DriverFactory();
      return instance;
   }

   public Logger log() 
   {
	  String log4jConfigFile = "C:\\Users\\Ajinkya_Chudiwal\\eclipse-workspace\\Framework\\log4j.properties";
      PropertyConfigurator.configure(log4jConfigFile);
      return logger;
   }
}