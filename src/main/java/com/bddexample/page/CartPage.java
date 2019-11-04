package com.bddexample.page;

public class CartPage extends BasePage<CartPage>{
	private final static String XPATH_TOTAL_PRODUCT = "//td[@id='total_product']";
	private final static String PROCEED_CHECKOUT = "//a[./span[text()='Proceed to checkout']]";
	
	public boolean totalValueMinusShippingIs(String value) {
		return getDSL().getText(XPATH_TOTAL_PRODUCT).equals(value);
	}
	
	public CartPage waitUntilLoaded() {
		getDSL().waitUntilClickable(PROCEED_CHECKOUT);
		return this;
	}

}
