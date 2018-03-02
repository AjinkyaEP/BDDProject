package org.stepDefinition;

import org.apache.log4j.Logger;
import org.config.Pom;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.pages.HomePage;
import org.testng.Assert;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinition 
{
	private static Logger log=Pom.logger.getLogger(StepDefinition.class);
	Pom pom =new Pom();
	
	@Before
    public void beforeScenario()
	{
		log.info("Inside Before Scenario");	
		pom.intializeDriver();
    }
	
	@Given("^user is on clear trip application homepage$")
	public void user_is_on_clear_trip_application_homepage() 
	{
		boolean page=HomePage.isDisplayed(pom);
		Assert.assertEquals(page, true, "Unable to display Home Page");
	}

	@Given("^user opts for one way trip$")
	public void user_opts_for_one_way_trip() 
	{
		log.info("Clicking on One Way option");
		HomePage.oneWayOption(pom).click();
	}

	@Given("^user enters flight from$")
	public void user_enters_flight_from()  
	{
		log.info("Entering Flight From");
	    HomePage.fromPlace(pom).sendKeys("Pune, IN - Lohegaon (PNQ)"+Keys.ENTER);
	}

	@Given("^user enters destination place to reach$")
	public void user_enters_destination_place_to_reach() 
	{
		 log.info("Entering Flight Destination");
		 HomePage.toPlace(pom).sendKeys("Mumbai, IN - Chatrapati Shivaji Airport (BOM)"+Keys.ENTER);
	}

	@Given("^user enters the departure date$")
	public void user_enters_the_departure_date() throws InterruptedException
	{
		log.info("Entering Departure Date");
		HomePage.departureDate(pom).click();
		Thread.sleep(1000);
		HomePage.enterDepartureDate(pom).click();
		Thread.sleep(1000);
	}

	@Given("^user selects number of traveller$")
	public void user_selects_number_of_traveller() throws InterruptedException 
	{
		log.info("Entering number of travellers");
		Select selectAdults = new Select(HomePage.adults(pom));
		selectAdults.selectByValue("1");
		
		Select selectChildren= new Select(HomePage.children(pom));
		selectChildren.selectByValue("1");
		
		Select selectInfants = new Select(HomePage.infants(pom));
		selectInfants.selectByValue("1");	
		log.info("Travellers information entered successfully");
	}

	@When("^user clicks on search flights button$")
	public void user_clicks_on_search_flights_button() throws InterruptedException
	{
		HomePage.searchFlightButton(pom).click();
		Thread.sleep(1000);
	}

	@Then("^user should be displayed with appropriate result$")
	public void user_should_be_displayed_with_appropriate_result() 
	{
		//System.out.println(driver.getTitle());
		
	}
	
	@After
    public void afterScenario()
	{
	   log.info("Inside After Scenario");
	   pom.quitDriver();
    }
}
