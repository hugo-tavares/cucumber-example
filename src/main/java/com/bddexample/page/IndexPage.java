package com.bddexample.page;

public class IndexPage extends BasePage<IndexPage>{
	private static final String XPATH_ITEM_NAME_PRICE = "//div[@class='product-container' and .//a[@title='%s'] and .//span[normalize-space(text())='%s']]";
	private static final String XPATH_ADD_TO_CART = "//a[./span[text()='Add to cart']]";
	private static final String XPATH_PROCEED_CHECKOUT = "//span[normalize-space(.) = 'Proceed to checkout']";
	private static final String XPATH_CONTINUE_SHOPPING = "//span[normalize-space(.) = 'Continue shopping']";
	private static final String XPATH_QUICK_VIEW = "//a[@class='quick-view']";
	private static final String XPATH_VIEW_SHOPPING_CART = "//a[@title='View my shopping cart']";
	private static final String XPATH_CART_ITEM_NAME_PRICE = "//div[@class='cart-info' and .//a[@title='%s'] and .//span[@class= 'price'][normalize-space(text()='%s')]]";
	
	public IndexPage addToCart(String item, String price) {
		String itemXpath = String.format(XPATH_ITEM_NAME_PRICE, item, price);
		getDSL()
			.hover(itemXpath)
			.click(itemXpath + XPATH_ADD_TO_CART);
		return this;
	}
	
	public IndexPage continueShopping() {
		getDSL().click(XPATH_CONTINUE_SHOPPING);
		return this;
	}
	
	public CartPage proceedCheckout() {
		getDSL().click(XPATH_PROCEED_CHECKOUT);
		return new CartPage();
	}
	
	public QuickViewPage goToQuickView(String item, String price) {
		String itemXpath = String.format(XPATH_ITEM_NAME_PRICE, item, price);
		getDSL()
			.hover(itemXpath)
			.click(itemXpath + XPATH_QUICK_VIEW);
		return new QuickViewPage();
	}
	
	public boolean isItemInTheCart(String item, String price) {
		return getDSL()
			.hover(XPATH_VIEW_SHOPPING_CART)
			.isPresentWithWait(String.format(XPATH_CART_ITEM_NAME_PRICE, item, price));
	}

}
