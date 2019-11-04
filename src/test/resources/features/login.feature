@Login @Ignore
Feature: Sign In

Background:
		Given I go to the website's url
		
  Scenario Outline: Login with non-registered credentials
    When I try to sign in typing the email <email> and password <password>
    Then the "Authentication failed" should be shown

    Examples: 
      | email                     | password          |
      | "ashduashd@gmail.com"     | "asdasdasd"       |
      | "asdsada@asdsad.com"      | "asd123"          |
      | "asd21@notregistered.com" | "invalidpassword" |

  @tag2
  Scenario: Login with registered credentials
  	This scenario assumes that the credentials passed in the first step refer to an already registered account.
  	
    When I try to sign in typing the email "testing@testing.testing" and password "12345"
    Then I should be redirected to the MY ACCOUNT page
