package com.bddexample.page;

public class QuickViewPage extends BasePage<QuickViewPage> {
	private static final String XPATH_WISHLIST = "//a[@id='wishlist_button']";
	private static final String XPATH_ERROR_MESSAGE = "//*[@class='fancybox-error' and normalize-space(text())='%s']";
	private static final String XPATH_PRODUCT_DETAILS = "//div[@class='product_attributes clearfix']";
	private static final String XPATH_IFRAME = "//iframe[@class='fancybox-iframe']";
	
	public QuickViewPage addToWishList() {
		getDSL().switchToFrame(XPATH_IFRAME)
			.click(XPATH_WISHLIST);
		return this;
	}
	
	public boolean errorWasShown(String errorMessage) {

		return getDSL().isPresentWithWait(String.format(XPATH_ERROR_MESSAGE, errorMessage));
	}
	
	public QuickViewPage waitUntilLoaded() {
	// Not ideal but for some reason Selenium is changing to the frame before it loads and then it can't find the element in the next step
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		getDSL()
			.switchToFrame(XPATH_IFRAME)
			.waitUntilExistent(XPATH_PRODUCT_DETAILS)
			.switchToDefault();
		return this;
	}
}
