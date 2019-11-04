package com.bddexample.stepdefinition;

import com.bddexample.page.CartPage;
import com.bddexample.page.IndexPage;
import com.bddexample.page.LoginPage;
import com.bddexample.page.QuickViewPage;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomationPracticeStepDefinition {
	private IndexPage indexPage = new IndexPage();
	private QuickViewPage quickView = new QuickViewPage();
	private LoginPage loginPage = new LoginPage();
	private CartPage cartPage = new CartPage();
	
	private String currentItem;
	private String currentPrice;
	
	@After()
	public void closeBrowser() throws InterruptedException {
		indexPage.closeBrowser();
	}
	
	@Given("I go to the website's url")
	public void iGoToTheWebsiteSUrl() {
	    indexPage.goToIndex();
	}

	@Given("I put the item {string} which costs {string} in the shopping cart")
	public void iPutTheItemWhichCostsInTheShoppingCart(String name, String price) {
		currentItem = name;
		currentPrice = price;
	   indexPage.addToCart(name, price);
	}

	@Given("I chose to continue shopping")
	public void iChoseToContinueShopping() {
	    indexPage.continueShopping();
	}

	@When("I reload the page")
	public void iReloadThePage() {
	    indexPage.refreshPage();
	}

	@Then("the item must remain in the cart")
	public void theItemMustRemainInTheCart() {
	    indexPage.isItemInTheCart(currentItem, currentPrice);
	}

	@Given("I chose to proceed to checkout")
	public void iChoseToProceedToCheckout() {
	    indexPage
	    	.proceedCheckout()
	    	.waitUntilLoaded();
	}

	@When("I try to sign in typing the email {string} and password {string}")
	public void iTryToSignInTypingTheEmailAndPassword(String email, String password) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("I should be redirected to the MY ACCOUNT page")
	public void iShouldBeRedirectedToTheMYACCOUNTPage() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	@Then("the total price minus shipping cost should be {string}")
	public void theTotalPriceMinusShippingCostShouldBe(String value) {
	    cartPage.totalValueMinusShippingIs(value);
	    
	}
	
	@Given("I go to the quick view of the product called {string} which costs {string}")
	public void iGoToTheQuickViewOfTheProductCalledWhichCosts(String item, String price) {
	   indexPage
	    .goToQuickView(item, price)
	   	.waitUntilLoaded();
	}

	@When("I try to add it to my wishlist")
	public void iTryToAddItToMyWishlist() {
	    quickView.addToWishList();
	}

	@Then("the message {string} should be shown")
	public void theMessageShouldBeShown(String errorMessage) {
	    quickView.errorWasShown(errorMessage);
	}
}
