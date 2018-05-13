Feature: sample karate test script    
    If you are using Eclipse, install the free Cucumber-Eclipse plugin from
    https://cucumber.io/cucumber-eclipse/
    Then you will see syntax-coloring for this file. But best of all,
    you will be able to right-click within this file and [Run As -> Cucumber Feature].
    If you see warnings like "does not have a matching glue code",
    go to the Eclipse preferences, find the 'Cucumber User Settings'
    and enter the following Root Package Name: com.intuit.karate    
    Refer to the Cucumber-Eclipse wiki for more: http://bit.ly/2mDaXeV
    
Background:
* url 'http://localhost:8090/'
    
Scenario: create an Inventory Summary and then get it by id, then delete

* def summary =
"""
{
	"inventoryLocation" : "BRISTOL"
}
"""

Given path 'depot/10001/inventory_summaries'
And request summary
When method post
Then status 201

* def location = responseHeaders['Location'][0]
* print 'created id is: ' + location

Given url location
When method get
Then status 200
# And match response contains user

Given url location
And request
"""
{
	"inventoryLocation" : "BRISTOL2"
}
"""
When method put
Then status 204

Given url location
When method delete
Then status 200

Scenario: Get a list of Inventory Summaries

Given path 'depot/10001/inventory_summaries'
When method get
Then status 200


Scenario: Get a non-existent Summary

Given path 'depot/10001/inventory_summaries/888888888888'
When method get
Then status 404