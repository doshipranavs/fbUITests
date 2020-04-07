
Feature: This is a sample feature

  @general
  Scenario Outline:User Launch Googlemail page and enter email
    Given googlemail page is up and running
    When the user enter email "<username>" and navigate to next page
    Examples:
      |username|
      |doshipranav88|

  @notimplemented
  Scenario: User Launch Googlemail page and check for any accessibility issues
    Given I am on google page
    When I tried to login with valid email and password
    Then I should be able to see inbox

  @manual
    Scenario: User Launch Googlemail page and check for any accessibility issues
    Given googlemail page is up and running
    When user run accessibility scan to check if there is any issues

    @manual
  Scenario Outline:User Launch Yahoomail page and enter email
    Given yahoomail page is up and running
    When the user enter email "<username>" and navigate to next page
    Examples:
      |username|
      |doshipranav82|

