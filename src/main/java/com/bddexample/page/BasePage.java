package com.bddexample.page;

import com.bddexample.core.DSL;

public abstract class BasePage<T extends BasePage<T>> {
	private DSL dsl;
	
	private static final String INDEX_URL = "http://automationpractice.com/index.php";
	private static final String LOGIN_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	
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
	
//	public LoginPage goToLoginPage() {
//		
//		return new LoginPage();
//	}
//	
//	public LoginPage goToLoginPage() {
//		
//		return new LoginPage();
//	}
//	
//	@SuppressWarnings("unchecked")
//	public T selecionarDia(String dia) {
//		return (T) this;
//	}
}