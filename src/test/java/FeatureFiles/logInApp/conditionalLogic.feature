Feature: Example feature to wait until response is not null

  Background: 

  @logicalCondition
  Scenario: Wait until response is not null
   * def myValue = "hello"
   * def finalValue = myValue == "hello" ? "success" : "failed"
   * print finalValue
 * def myResponse = if ( myValue == 'hello' ) "success"
* print myResponse
#    * if(myValue=="hello")
   
* def myRandom = Math.floor(Math.random() * 1000)
* print myRandom