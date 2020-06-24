Feature: Karate Beer API - Data Driven Development

  Background:
    * url baseUrl
    * configure afterScenario =
    """
    function(){
      var info = karate.info;
      karate.log('after', info.scenarioType + ':', info.scenarioName);
    }
    """

  Scenario Outline: Use table to create <name> brewers
    Given path 'brewers'
    When method get
    Then status 200
    * print $.content.length()
    And def numberOfBrewers = $.content.length()
    Given path 'brewers'
    And request { id: '#(id)', name: '#(name)', country: '#(country)' }
    When method post
    Then status 200
    Given path 'brewers'
    When method get
    Then status 200
#    Should break parallel test because other scenarios may add data to database
#    And match (numberOfBrewers + 1) == $.content.length()
#   Better in parallel test
    And match $.content[*].id contains <id>

    Examples:
      | id | name           | country     |
      | 15 | '15th Brewery' | 'USA'       |
      | 16 | '1664'         | 'France'    |
      | 17 | 'Green Dragon' | 'The Shire' |

  Scenario Outline: Delete freshly created brewers <id>
    Given path 'brewers', __row.id
    When method delete
    Then status 200

    Examples:
      | id |
      | 15 |
      | 16 |
      | 17 |
