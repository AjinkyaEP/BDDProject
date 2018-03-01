package org.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.config.DriverFactory;
import org.config.Pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.stepDefinition.StepDefinition;


public class HomePage
{
	private static Logger log=Pom.logger.getLogger(HomePage.class);
	private static WebDriver driver=StepDefinition.driver;
	private static WebElement element=null;
	private static String pageName="#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.";
	private static String oneWayRadioButton="//*[@id='OneWay']";
	private static String fromPlace="//*[@id='FromTag']";
	private static String toPlace="//*[@id=\"ToTag\"]";
	private static String departDate="//*[@id=\"ORtrip\"]/section[2]/div[1]/dl/dd/div/a/i";
	private static String departureDate="//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[4]/td[1]/a";
	private static String numberOfAdults="//*[@id='Adults']";
	private static String numberOfChildren="//*[@id='Childrens']";
	private static String numberOfInfants="//*[@id='Infants']";
	private static String searchFlightButton="//*[@id=\"SearchBtn\"]";
	
	
	public static boolean isDisplayed() 
	{
		String pageTitle = driver.getTitle();
		if (pageTitle.equals(pageName))
		{
			
			return true;
		}
		else
		{
			log.error("Current page is not the required page "+pageTitle);
			return false;
		}
	}
	
	
	public static WebElement oneWayOption() 
	{
		element=driver.findElement(By.xpath(oneWayRadioButton));
		if (element==null)
			log.error("Unable to locate element for one way radio button");
		return element;
	}
	
	public static WebElement fromPlace() 
	{
		element=driver.findElement(By.xpath(fromPlace));
		if (element==null)
			log.error("Unable to locate element From place");
		return element;
	}
	
	public static WebElement toPlace() 
	{
		element=driver.findElement(By.xpath(toPlace));
		if (element==null)
			log.error("Unable to locate element To place");
		return element;
	}
	
	public static WebElement departureDate()
	{
		List<WebElement>driver1=driver.findElements(By.xpath("//*[@id=\"DepartDate\"]"));
		element=driver1.get(0);
		if (element==null)
			log.error("Unable to locate element Depart date calendar");
		return element;
	}
	
	public static WebElement enterDepartureDate()
	{
		List<WebElement>driver1=driver.findElements(By.xpath("//*[@data-handler=\"selectDay\" and @data-year=\"2018\"]"));
		element=driver1.get(10);
		if (element==null)
			log.error("Unable to locate element Depart date calendar");
		return element;
	}
	
	public static WebElement adults()
	{
		element=driver.findElement(By.xpath(numberOfAdults));
		if (element==null)
			log.error("Unable to locate element for entering number of Adults");
		return element;
	}
	
	public static WebElement children()
	{
		element=driver.findElement(By.xpath(numberOfChildren));
		if (element==null)
			log.error("Unable to locate element for entering number of Children");
		return element;
	}
	
	public static WebElement infants()
	{
		element=driver.findElement(By.xpath(numberOfInfants));
		if (element==null)
			log.error("Unable to locate element for entering number of Infants");
		return element;
	}
	
	public static WebElement searchFlightButton()
	{
		element=driver.findElement(By.xpath(searchFlightButton));
		if (element==null)
			log.error("Unable to locate Search flight button");
		return element;
	}
	
}
