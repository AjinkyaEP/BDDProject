#Author: Ajinkya_Chudiwal@epam.com
#Keywords Summary : This feature file consists of customer journey while searching the flight on Clear Trip application
#Feature: Search for a flight

@SearchFlight
Feature: To search for a flight.

#This is positive journey where customer tries to validate whether is able to search for flight in one way direction
@SearchFlightOneWay
  Scenario: To verify whether user is able to search for flight on one way journey
    Given user is on clear trip application homepage
    And user opts for one way trip
    And user enters flight from 
    And user enters destination place to reach
    And user enters the departure date
    And user selects number of traveller
    When user clicks on search flights button
    Then user should be displayed with appropriate result

#This is positive journey where customer tries to validate whether he is able to search for flight in both way direction    
@SearchFlightBothWay
  Scenario: To verify whether user is able to search for flight on one way journey
    Given user is on clear trip application homepage
    And user opts for both way trip
    And user enters flight from 
    And user enters destination place to reach
    And user enters the departure date
    And user selects number of traveller
    When user clicks on search flights button
    Then user should be displayed with appropriate result    