Feature: Gold Bar Weight Check

  @test
  Scenario: Find the fake gold bar
    Given I am on the SDET challenge site
    When  I check the all combinations to find a fake gold bar
    Then  I confirm that I found the fake gold bar
    And   I output the weighing information

