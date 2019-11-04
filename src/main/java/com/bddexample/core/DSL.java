package com.bddexample.core;

import static com.bddexample.core.DriverFactory.closeWebDriver;
import static com.bddexample.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {

	private static final int DEFAULT_WAIT_TIME = 10;

	public DSL() {
	}

	public DSL goToUrl(String url) {
		getDriver().get(url);
		return this;
	}

	public DSL typeField(String xpath, String text) {
		WebElement field = clickElement(xpath);
		field.sendKeys(text);
		return this;
	}
	
	public DSL click(String xpath) {
		this.clickElement(xpath);
		return this;
	}
	
	public DSL waitUntilInvisible(String xPath) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPath)));
		return this;
	}

	public void closeBrowser() throws InterruptedException {
		closeWebDriver();
	}

	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}
	
	public String getText(String xpath) {
		return getElement(xpath).getText().trim();
	}
	
	public boolean isPresent(String xpath) {
		return getDriver().findElements(By.xpath(xpath)).size() != 0;
	}
	public boolean isPresentWithWait(String xpath) {
		boolean found = true;
		try {
			getElement(xpath);
		} catch (NoSuchElementException e) {
			found = false;
		}
		return found;
	}
	public DSL type(String xpath, String text) {
		WebElement element = getElement(xpath);
		element.clear();
		element.sendKeys(text + Keys.ENTER);	
		return this;
	}
	
	public DSL waitUntilClickable(String xpath) {
		(new WebDriverWait(getDriver(), 10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		return this;
	}
	public DSL hover(String xpath) {
		Actions actions = new Actions(DriverFactory.getDriver());
		actions.moveToElement(getElement(xpath)).build().perform();
		return this;
	}
	
	public void waitUntilExistent(String xPath) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(xPath))));
	}
	
	private WebElement getElement(String xpath) {
		waitUntilExistent(xpath);
		return getDriver().findElement(By.xpath(xpath));
	}
	
	private DSL scrollToElement(WebElement element) {
		runJavaScript("arguments[0].scrollIntoView(true);", element);
		return this;
	}

	private Object runJavaScript(String code, Object... parameters) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(code, parameters);
	}

	private WebElement clickElement(String xpath) {
		WebElement element = null;
		try {
			element = (new WebDriverWait(getDriver(), DEFAULT_WAIT_TIME))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			element.click();
		} catch (WebDriverException e) {
			scrollToElement(getElement(xpath));
			element = (new WebDriverWait(getDriver(), DEFAULT_WAIT_TIME))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			element.click();
		}
		return element;
	}
}
