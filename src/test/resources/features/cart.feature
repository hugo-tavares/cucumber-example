
@Cart
Feature: Shopping Cart
	
	Background:
		Given I go to the website's url

  Scenario: Putting an item in the cart and refreshing the page and checking if the item remains in the cart
    Given I put the item "Blouse" which costs "$27.00" in the shopping cart
    And I chose to continue shopping
    When I reload the page
    Then the item must remain in the cart

  Scenario: Putting two items in the cart and checking if the prices are correctly added 
    Given I put the item "Printed Dress" which costs "$26.00" in the shopping cart
    And I chose to continue shopping
    And I put the item "Printed Dress" which costs "$50.99" in the shopping cart
    And I chose to proceed to checkout
    Then the total price minus shipping cost should be "$76.99"

