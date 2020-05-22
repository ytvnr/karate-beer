Feature: Karate Beer API - Reuse features

  Background:
    * url baseUrl

  Scenario: Reuse Get One Beer feature
    Given def result = call read('reusable/GetOneBeer.feature') { id: 1 }
    Then match result.response.id == 1
    Then match result.response contains { name: 'Karmeliet Tripel' }
    Given def result = call read('reusable/GetOneBeer.feature') { id: 2 }
    Then match result.response.id == 2
    Then match result.response contains { name: 'La Chouffe' }

  Scenario: Reuse Get By Name Regex
    Given def result = call read('reusable/GetBeerByNameRegex.feature') { regex: 'ar', length: 2 }
    Then match result.response[0] == { id: '#number', name: '#regex [a-zA-Z ]*ar{1}[a-zA-Z ]*', strength: '#ignore', brewer: '#ignore' }
