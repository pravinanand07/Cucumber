package com.telecom.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	
	static WebDriver driver;
	
	@Before
	public void beforescenario() {
		
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/telecom/");
		
	}
	
	@After
	public void afterscenario() {
		
		driver.close();
	}

}
