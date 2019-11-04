package com.bddexample.page;

import com.bddexample.core.DSL;

public abstract class BasePage<T extends BasePage<T>> {
	private DSL dsl;
	
	private static final String INDEX_URL = "http://automationpractice.com/index.php";
	private static final String LOGIN_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	protected static final String XPATH_LOADING = "//div[@id='fancybox-loading']";
	
	protected DSL getDSL() {
		if (dsl == null) {
			dsl = new DSL();			
		}
		return dsl;
	}
	
	public void closeBrowser() throws InterruptedException {
		getDSL().closeBrowser();
	}
	
	public LoginPage goToLogin() {
		getDSL().goToUrl(LOGIN_URL);
		return new LoginPage();
	}
	
	public IndexPage goToIndex() {
		getDSL().goToUrl(INDEX_URL);
		return new IndexPage();
	}
	
	@SuppressWarnings("unchecked")
	public T refreshPage() {
		getDSL().refresh();
		return (T) this;
	}
}
