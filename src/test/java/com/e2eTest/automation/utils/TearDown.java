package com.e2eTest.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class TearDown {
	
	
	@After
	public void quitDriver(Scenario scenario) {
		
	if (scenario.isFailed()) {
		final byte [] screenShot = ((TakesScreenshot) Setup.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenShot, "image/png", "ScreenShot :" + scenario.getName());
		
		
	}

	Setup.getDriver().close();
	Setup.getLooger().info("scenario :" + scenario.getName() + "is finished.status : "+ scenario.getStatus());
	
}
}
