Feature: Actuator api

  Background:
    * url baseUrl
    * configure connectTimeout = 500000

  Scenario: actuator resource is available
    Given path '/actuator'
    When method get
    Then status 200

  Scenario: health resource status is "up"
    Given path '/actuator/health'
    When method get
    Then status 200
    And match response == {'status':'UP'}


  Scenario Outline: name test <NAME>
    * def temp = '<NAME>'
    Given path '/' + __row.name
    #Given path '/' + #(name)
    When method get
    Then status 200
    And match response == "Hello ashish"

    Examples:
      | name   | age |
      | ashish | 5   |

  Scenario Outline: one from another
    * def obj = { name: '#(__row.name)'}
    #* print 'obj.name: ' + obj.name
   #* def result = call read('classpath:karate/some-reusable-steps.feature') obj
    #* def result = call read('classpath:karate/some-reusable-steps.feature') { name: '#(__row.name)'}
    * def fn = 'ash';
    #* def result = call read('classpath:karate/some-reusable-steps.feature@hello') { name: '#(fn)' }
    * def result = call read('classpath:karate/some-reusable-steps.feature@hello') { name: <name>}
    * print result.response
    And match result.response == "Hello <name>"
    Examples:
      | name |
      | sam  |
