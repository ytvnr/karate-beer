Feature: Karate Beer API - Java Interop

  Background:
    * url baseUrl
    * def TestUtils = Java.type('io.ytvnr.karatebeer.TestUtils')
    * def logMessage =
    """
    function(s) {
      var system = Java.type('java.lang.System');
      system.out.println(s);
    }
    """

  Scenario: Log messages from feature and from Java class
    Given path 'beers'
    * TestUtils.logTime()
    When method get
    Then status 200
    And match $.content.length() == 5
    * TestUtils.logTime()
    * call logMessage 'First element is: '
    * call logMessage $.content[0].name
