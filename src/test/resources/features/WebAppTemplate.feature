
Feature: This is a Template feature

  @general
  Scenario:User Launch Template Home page and navigate to sigin to an account
    Given Template Home page is up and running
    When user click on sign in to Account
    Then user should be able to see sign in page

  @general
  Scenario: User Launch Template Home page and check for any accessibility issues
    Given Template Home page is up and running
    When user run accessibility scan to check if there is any issues