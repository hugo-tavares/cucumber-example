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

		getDSL()
			.waitUntilInvisible(XPATH_LOADING)
			.switchToFrame(XPATH_IFRAME)
			.waitUntilExistent(XPATH_PRODUCT_DETAILS)
			.switchToDefault();
		return this;
	}
}
