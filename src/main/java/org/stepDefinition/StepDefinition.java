package org.stepDefinition;

import org.apache.log4j.Logger;
import org.config.Pom;
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
	@Before
    public void beforeScenario()
	{
		log.info("Inside Before Scenario");
		Pom.driver.get(Pom.url);   
    }
	
	@Given("^user is on clear trip application homepage$")
	public void user_is_on_clear_trip_application_homepage() 
	{
		boolean page=HomePage.isDisplayed();
		Assert.assertEquals(page, true, "Unable to display Home Page");
	}

	@Given("^user opts for one way trip$")
	public void user_opts_for_one_way_trip() 
	{
	    
	}

	@Given("^user enters flight from$")
	public void user_enters_flight_from()  
	{
	    
	}

	@Given("^user enters destination place to reach$")
	public void user_enters_destination_place_to_reach() 
	{
	}

	@Given("^user enters the departure date$")
	public void user_enters_the_departure_date() 
	{
	}

	@Given("^user selects number of traveller$")
	public void user_selects_number_of_traveller() 
	{
	}

	@When("^user clicks on search flights button$")
	public void user_clicks_on_search_flights_button()
	{
	}

	@Then("^user should be displayed with appropriate result$")
	public void user_should_be_displayed_with_appropriate_result() 
	{
	}
	@After
    public void afterScenario()
	{
	   log.info("Inside After Scenario");
       Pom.driver.quit();
    }
}
