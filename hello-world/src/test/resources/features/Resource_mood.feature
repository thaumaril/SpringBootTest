Feature: Resource_mood Cucumber's Tests
  This Feature file, test the Resource /mood/


  Scenario: Call the Rest-Resource /mood/new and expect a valid answer
    When the Rest-Resource /mood is called
    Then the expected answer is OK
    And the amount of Moods in the Database is 2

