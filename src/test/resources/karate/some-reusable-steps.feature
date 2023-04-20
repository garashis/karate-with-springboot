Feature: My Controller Call

  Background:
    * url baseUrl

  Scenario: hello controller
    Given path '/' + __arg.name
    #Given path '/' + __arg
    When method get
    Then status 200