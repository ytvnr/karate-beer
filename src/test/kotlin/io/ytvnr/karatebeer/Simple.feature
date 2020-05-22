Feature: Karate Beer API - Simple get

  Background:
    * url baseUrl

  Scenario: Get all beers for the first time
    Given path 'beers'
    When method get
    Then status 200
    And match $.content.length() == 5

  Scenario: Get the first beer
    Given path 'beers/1'
    When method get
    Then status 200
    And match $.id == 1
    And match $.name == 'Karmeliet Tripel'

  Scenario: Add a testing beer to a non existing Brewer
    Given path 'beers'
    And request
    """
    {
      id: 42,
      name: 'Testing Beer',
      strength: 42.0,
      brewer: {
        id: 42,
        name: 'Testing Brewer',
        country: 'Test Land'
      }
    }
    """
    When method post
    Then status 500

  Scenario: Create a testing brewer and add a beer
    Given path 'brewers'
    And request
    """
    {
      id: 42,
      name: 'Testing Brewer',
      country: 'Test Land'
    }
    """
    When method post
    Then status 200
    And match $.id == 42
    And match $.name == 'Testing Brewer'
    * def createdTestingBrewer = $
    Given path 'beers'
    * def payload =
    """
    {
      id: 42,
      name: 'Testing Beer',
      strength: 42.0,
      brewer:  #(createdTestingBrewer)
    }
    """
    And request payload
    When method post
    Then status 200

  Scenario: Delete feature related data
    Given path 'brewers/42'
    When method delete
    Then status 200
    Given path 'beers/42'
    When method delete
    Then status 200
