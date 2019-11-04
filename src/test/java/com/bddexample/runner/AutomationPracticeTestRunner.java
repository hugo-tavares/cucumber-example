package com.bddexample.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                 plugin = { "pretty" }, 
				 glue = { "com.bddexample.stepdefinition"},
				 snippets = SnippetType.CAMELCASE,
				 tags = { "not @Ignore" })
public class AutomationPracticeTestRunner {

}
