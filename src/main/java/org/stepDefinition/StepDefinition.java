/**************************************************************************************************************
 OBJECTIVE:- This is a Step Definition class which provides implementation for cucumber feature file steps.
 AUTHOR:- Ajinkya Chudiwal	
 EMAIL:-ajinkya_chudiwal@epam.com
 DATE:- 05/03/2018
 **************************************************************************************************************/
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
	private static Logger log=Pom.log().getLogger(StepDefinition.class);
	Pom pom =new Pom();
	
	//This Before hook assists in initializing Web driver
	@Before
    public void beforeScenario()
	{
		log.info("Inside Before Scenario");	
		pom.intializeDriver();
    }
	
	//This step definition verifies whether user is on home page of clear trip application
	@Given("^user is on clear trip application homepage$")
	public void user_is_on_clear_trip_application_homepage() 
	{
		boolean page=HomePage.isDisplayed(pom);
		Assert.assertEquals(page, true, "Unable to display Home Page");
	}

	//This step definition assists in selecting one way trip option for user's journey
	@Given("^user opts for one way trip$")
	public void user_opts_for_one_way_trip() 
	{
		log.info("Clicking on One Way option");
		HomePage.oneWayOption(pom).click();
	}
	
	//This step definition assists in selecting return trip option for user's journey
	@Given("^user opts for return trip$")
	public void user_opts_for_return_trip() 
	{
		log.info("Clicking on Round trip option");
		HomePage.twoWayOption(pom).click();
	}
	
	//This step definition assists user in entering place from where he needs to travel
	@Given("^user enters flight from$")
	public void user_enters_flight_from()  
	{
		log.info("Entering Flight From");
	    HomePage.fromPlace(pom).sendKeys("Pune, IN - Lohegaon (PNQ)"+Keys.ENTER);
	}

	//This step definition assists user in entering destination place where he needs to travel
	@Given("^user enters destination place to reach$")
	public void user_enters_destination_place_to_reach() 
	{
		 log.info("Entering Flight Destination");
		 HomePage.toPlace(pom).sendKeys("Mumbai, IN - Chatrapati Shivaji Airport (BOM)"+Keys.ENTER);
	}

	//This step definition assist user in entering departure date
	@Given("^user enters the departure date$")
	public void user_enters_the_departure_date() throws InterruptedException
	{
		log.info("Entering Departure Date");
		HomePage.departureDate(pom).click();
		Thread.sleep(1000);
		HomePage.enterDate(pom).click();
		Thread.sleep(1000);
	}
	
	//This step definition assist user in entering return date from the destination place
	@Given("^user enters the return date$")
	public void user_enters_the_return_date() throws InterruptedException
	{
		log.info("Entering Return Date");
		HomePage.returnDate(pom).click();
		Thread.sleep(1000);
		HomePage.enterDate(pom).click();
		Thread.sleep(1000);
	}

	//This step definition assist user in selecting number of Adults, Infants and Children.
	@Given("^user selects \"(.*?)\" \"(.*?)\" and \"(.*?)\"$")
	public void user_selects_and(String numberOfAdults, String numberOfInfants, String numberOfChildren)
	{
		log.info("Entering number of travellers");
		Select selectAdults = new Select(HomePage.adults(pom));
		selectAdults.selectByValue(numberOfAdults);		//Select number of Adults.
		
		Select selectChildren= new Select(HomePage.children(pom));
		selectChildren.selectByValue(numberOfChildren);	//Select number of Children.
		
		Select selectInfants = new Select(HomePage.infants(pom));
		selectInfants.selectByValue(numberOfInfants);	//Select number of Infants.
		log.info("Travellers information entered successfully");
	}

	//This step definition assist user in clicking on search button.
	@When("^user clicks on search flights button$")
	public void user_clicks_on_search_flights_button() throws InterruptedException
	{
		Thread.sleep(1000);
		HomePage.searchFlightButton(pom).click();
		Thread.sleep(1000);
	}

	//This step definition assist user to verify whether he is on correct page after clicking on search button on Home Page of Clear Trip application portal.
	@Then("^user should be displayed with appropriate result$")
	public void user_should_be_displayed_with_appropriate_result() 
	{
		//System.out.println(driver.getTitle());	
	}
	
	//This After hook definition assist to quit driver after running the test scenario.
	@After
    public void afterScenario()
	{
	   log.info("Inside After Scenario");
	   pom.quitDriver();
    }
}
