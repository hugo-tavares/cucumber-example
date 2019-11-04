@QuickView @Implemented
Feature: Quick View

  Background: 
    Given I go to the website's url

  Scenario: Trying to add to the wishlist without being logged in
    Given I go to the quick view of the product called "Blouse" which costs "$27.00"
    When I try to add it to my wishlist
    Then the message "You must be logged in to manage your wishlist." should be shown
