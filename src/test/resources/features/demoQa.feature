# demo.feature
Feature: DemoQA Website Testing

  Scenario: Verify navigation to Elements page
    Given I am on the DemoQA homepage
    When I click on the Elements card
    Then I should be redirected to the Elements page