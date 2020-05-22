@ignore
Feature: the id is expected to be set as a call arg


  Scenario:
    Given url baseUrl
    And path 'beers/byName', __arg.regex
    When method get
    Then status 200
    And match $.length() == __arg.length
