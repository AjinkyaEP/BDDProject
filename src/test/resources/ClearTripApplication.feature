#Author: Ajinkya_Chudiwal@epam.com
#Keywords Summary : This feature file consists of different customer journey while searching the flight on Clear Trip application
#Feature: Search for a flight
@SearchFlight
Feature: To search for a flight.

  #This is positive journey where customer tries to validate whether he is able to search for flight in one way direction.
  @SearchFlightOneWay
  Scenario Outline: To verify whether user is able to search for flight on one way journey.
    Given user is on clear trip application homepage
    And user opts for one way trip
    And user enters flight from
    And user enters destination place to reach
    And user enters the departure date
    And user selects "<numberOfAdults>" "<numberOfInfants>" and "<numberOfChildren>"
    When user clicks on search flights button
    Then user should be displayed with appropriate result

    Examples: 
      | numberOfAdults | numberOfInfants | numberOfChildren |
      |              1 |               1 |                1 |
      |              2 |               2 |                2 |
      |              2 |               2 |                1 |

  #This is positive journey where customer tries to validate whether he is able to search for round way flight.
  @SearchFlightBothWay
  Scenario Outline: To verify whether user is able to search for flight for round trip journey.
    Given user is on clear trip application homepage
    And user opts for return trip
    And user enters flight from
    And user enters destination place to reach
    And user enters the departure date
    And user enters the return date
    And user selects "<numberOfAdults>" "<numberOfInfants>" and "<numberOfChildren>"
    When user clicks on search flights button
    Then user should be displayed with appropriate result
    Examples: 
      | numberOfAdults | numberOfInfants | numberOfChildren |
      |              1 |               1 |                1 |
      |              2 |               2 |                2 |
      |              2 |               2 |                1 |
      