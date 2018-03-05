/**************************************************************************************************************************
 OBJECTIVE:- This is a Home Page class which assists to search different objects on Home Page of Clear trip application .
 AUTHOR:- Ajinkya Chudiwal	
 EMAIL:-ajinkya_chudiwal@epam.com
 DATE:- 05/03/2018
 ***************************************************************************************************************************/
package org.pages;
import java.util.List;
import org.apache.log4j.Logger;
import org.config.Pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.stepDefinition.StepDefinition;

public class HomePage
{
	private static Logger log=Pom.log().getLogger(StepDefinition.class);
	private static WebElement element=null;
	private static String pageName="#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.";
	private static String oneWayRadioButton="//*[@id='OneWay']";
	private static String fromPlace="//*[@id='FromTag']";
	private static String toPlace="//*[@id=\"ToTag\"]";
	private static String numberOfAdults="//*[@id='Adults']";
	private static String numberOfChildren="//*[@id='Childrens']";
	private static String numberOfInfants="//*[@id='Infants']";
	private static String searchFlightButton="//*[@id=\"SearchBtn\"]";
	private static String twoWayRadioButton="//*[@id=\"RoundTrip\"]";
	
	//This method checks whether page is being loaded successfully.
	public static boolean isDisplayed(Pom pom)  
	{
		String pageTitle = pom.driver.getTitle();
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
	
	//This methods assists in finding one way option radio button when user tries to search flight.
	public static WebElement oneWayOption(Pom pom) 
	{
		element=pom.driver.findElement(By.xpath(oneWayRadioButton));
		if (element==null)
			log.error("Unable to locate element for one way radio button");
		return element;
	}
	
	//This methods assists in finding Round trip option radio button when user tries to search flight.
	public static WebElement twoWayOption(Pom pom)
	{
		element=pom.driver.findElement(By.xpath(twoWayRadioButton));
		if (element==null)
			log.error("Unable to locate element for return trip radio button");
		return element;
	}
	
	//This methods assists in finding text box where user can enter place from where he needs to fly.
	public static WebElement fromPlace(Pom pom) 
	{
		element=pom.driver.findElement(By.xpath(fromPlace));
		if (element==null)
			log.error("Unable to locate element From place");
		return element;
	}
	
	//This methods assists in finding text box where user can enter destination place where he needs to fly.
	public static WebElement toPlace(Pom pom) 
	{
		element=pom.driver.findElement(By.xpath(toPlace));
		if (element==null)
			log.error("Unable to locate element To place");
		return element;
	}
	
	//This method assists in searching for calendar icon on departure date calendar
	public static WebElement departureDate(Pom pom)
	{
		List<WebElement>driver1=pom.driver.findElements(By.xpath("//*[@id=\"DepartDate\"]"));
		element=driver1.get(0);
		if (element==null)
			log.error("Unable to locate element Depart date calendar");
		return element;
	}
	
	
	//This method assists in entering departure date on calendar
	public static WebElement enterDepartureDate(Pom pom)
	{
		List<WebElement>driver1=pom.driver.findElements(By.xpath("//*[@data-handler=\"selectDay\" and @data-year=\"2018\"]"));
		element=driver1.get(10);
		if (element==null)
			log.error("Unable to locate element Depart date calendar");
		return element;
	}
	
	//This method assist in searching drop down box for selecting number of adults.
	public static WebElement adults(Pom pom)
	{
		element=pom.driver.findElement(By.xpath(numberOfAdults));
		if (element==null)
			log.error("Unable to locate element for entering number of Adults");
		return element;
	}
	
	//This method assist in searching drop down box for selecting number of children.
	public static WebElement children(Pom pom)
	{
		element=pom.driver.findElement(By.xpath(numberOfChildren));
		if (element==null)
			log.error("Unable to locate element for entering number of Children");
		return element;
	}
	
	//This method assist in searching drop down box for selecting number of infants.
	public static WebElement infants(Pom pom)
	{
		element=pom.driver.findElement(By.xpath(numberOfInfants));
		if (element==null)
			log.error("Unable to locate element for entering number of Infants");
		return element;
	}
	
	//This method assist in searching search flight button.
	public static WebElement searchFlightButton(Pom pom)
	{
		element=pom.driver.findElement(By.xpath(searchFlightButton));
		if (element==null)
			log.error("Unable to locate Search flight button");
		return element;
	}
	
}
