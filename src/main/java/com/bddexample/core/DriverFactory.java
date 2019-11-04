package com.bddexample.core;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import com.bddexample.exceptions.InvalidBrowserException;


public class DriverFactory {
	private static WebDriver driver;
	private static String browserName = BrowserType.CHROME; // Chrome is defined as the standard browser

	private DriverFactory() {
	};	
	
	public static void setBrowserName(String browserName) {
		DriverFactory.browserName = browserName;
	}



	public static WebDriver getDriver() {
		if (driver == null) {
			try {
				Browser browser = Browser.validateBrowser(BrowserType.CHROME);
				String slash = File.separator; // OS compatibility
				String projectPath = System.getProperty("user.dir");
				System.setProperty(browser.getProperty(), projectPath + slash + "src" + slash + "main" + slash
						+ "resources" + slash + "webdrivers" + slash + browser.getFile());

				setWebDriver();
			} catch (InvalidBrowserException e) {
				System.out.println("Invalid Browser.");
			}
			driver.manage().window().maximize();
		}

		return driver;
	}


	public static void closeWebDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	private static void setWebDriver() throws InvalidBrowserException {
		if (browserName == "chrome" || browserName == "googlechrome") {
			driver = new ChromeDriver();
		}
		
		else if (browserName == "firefox") {
			driver = new FirefoxDriver();
		}
		
		else if (browserName == "internet explorer") {
			driver = new InternetExplorerDriver();
		}
		
		else if (browserName == "MicrosoftEdge") {
			driver = new EdgeDriver();
		} else
			throw new InvalidBrowserException();
	}
}
