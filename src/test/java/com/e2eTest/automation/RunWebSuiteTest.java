package com.e2eTest.automation;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;



@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/spec/feature"},
	//glue = {"step_definitions"},  ==>  if class runner in package 
	plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json"},
	tags = ("@authentification"),
	monochrome = true,
	snippets = CAMELCASE 
	
	
	
		
		
		
		)



public class RunWebSuiteTest {
	
	
	
	

}
