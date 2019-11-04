package com.bddexample.core;

import com.bddexample.exceptions.InvalidBrowserException;

public class Browser {
	private String name;
	private String property;
	private String file;
	
	public Browser(String name, String property, String file) {
		this.name = name;
		this.property = property;
		this.file = file;
	}
	
	public String getProperty() {
		return property;
	}
	
	public String getFile() {
		return file;
	}
	
	public String getName() {
		return name;
	}
	
	public static Browser validateBrowser(String browserName) throws InvalidBrowserException{
		if (browserName.equals("chrome") || browserName.equals("googlechrome")) {
			return new Browser("chrome","webdriver.chrome.driver", "chromedriver.exe");
		}

		else if (browserName.equals("firefox")) {
			return new Browser("firefox","webdriver.gecko.driver", "geckodriver.exe");
		}

		else if (browserName.equals("internet explorer")) {
			return new Browser("internet explorer","webdriver.ie.driver", "IEDriverServer.exe");
		}

		else if (browserName.equals("MicrosoftEdge")) {
			return new Browser("MicrosoftEdge", "webdriver.edge.driver", "MicrosoftWebDriver.exe");
		}
		throw new InvalidBrowserException();
		
	}
}
