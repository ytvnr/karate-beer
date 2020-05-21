Feature: Karate Beer API - Simple get

  Background:
    Given url baseUrl
#    Given url "http://localhost:8080/api"

  Scenario: Get all beers
    Given path 'beers'
    When method get
    Then status 200
