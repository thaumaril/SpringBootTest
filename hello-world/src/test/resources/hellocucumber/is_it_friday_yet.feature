Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario: Sunday isn't Friday
    Given today is "Sunday"
    When I ask whether it's Friday yet
    Then I should be told "Nope"

   Scenario: Call REST-Service and Check Status
   When I call the REST-Endpoint "http://localhost:8081/newmood"
   Then I suspect status 200

   Scenario: Call REST-Service and Check JSON
   When I call the REST-Endpoint "http://localhost:8081/newmood"
   #Then I suspect status 200
   Then I suspect JSON