package com.bddexample.page;

public class IndexPage extends BasePage<IndexPage>{
	private static final String XPATH_ITEM_NAME_PRICE = "//div[@class='product-container' and .//a[@title='%s'] and .//span[normalize-space(text())='%s']]";
	private static final String XPATH_ADD_TO_CART = "//a[./span[text()='Add to cart']]";
	private static final String XPATH_PROCEED_CHECKOUT = "//span[normalize-space(.) = 'Proceed to checkout']//a";
	private static final String XPATH_CONTINUE_SHOPPING = "//span[normalize-space(.) = 'Continue shopping']//a";
	
	public IndexPage addToCart(String item, String price) {
		String itemXpath = String.format(XPATH_ITEM_NAME_PRICE, item, price);
		getDSL()
			.hover(itemXpath)
			.click(itemXpath + XPATH_ADD_TO_CART);
		return this;
	}

}
