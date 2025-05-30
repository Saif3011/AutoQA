package com.e2eTest.automation.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Setup {

	private static WebDriver driver;
	private static Logger LOOGER = (Logger) LogManager.getLogger(Setup.class.getName());
@Before
	public void setWebDriver(Scenario scenario) {
		
		LOOGER.info("Scenario" + scenario.getName() +" -started");
		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = "chrome";
		}
		switch (browser) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new ChromeDriver(chromeOptions);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
			break;
		case "firefox":
			FirefoxProfile profile = new FirefoxProfile();
			FirefoxOptions firefoxOption = new FirefoxOptions();
			firefoxOption.setCapability("platform", Platform.WIN11);
			firefoxOption.setProfile(profile);
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
			break;

		case "edge":
			driver = new EdgeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
			break;
			default:
				throw new IllegalArgumentException("browser\"" +browser+ "\" is not supported");
			

		}

	}
      /*Getter*/
	public static WebDriver getDriver() {
		return driver;
	}
	public static Logger getLooger() {
		return LOOGER;
	}
	
	
	

}
