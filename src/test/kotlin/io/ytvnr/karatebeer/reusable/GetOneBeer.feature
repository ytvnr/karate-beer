@ignore
Feature: the id is expected to be set as a call arg

  Scenario:
    Given url baseUrl
    And path 'beers/', __arg.id
    When method get
    Then status 200
