package com.bddexample.stepdefinition;

import com.bddexample.page.IndexPage;

import cucumber.api.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomationPracticeStepDefinition {
	private IndexPage indexPage = new IndexPage();
	
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
	   indexPage.addToCart(name, price);
	}

	@Given("I chose to continue shopping")
	public void iChoseToContinueShopping() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("I reload the page")
	public void iReloadThePage() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("the item must remain in the cart")
	public void theItemMustRemainInTheCart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Given("I chose to proceed to checkout")
	public void iChoseToProceedToCheckout() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("I try to sign in typing the email {string} and password {string}")
	public void iTryToSignInTypingTheEmailAndPassword(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("the {string} should be shown")
	public void theShouldBeShown(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("I should be redirected to the MY ACCOUNT page")
	public void iShouldBeRedirectedToTheMYACCOUNTPage() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
}
