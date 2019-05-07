package com.automationChallenge.cucumber.runner;
 
import cucumber.api.CucumberOptions;
import cucumber.api.testng.*;
 
@CucumberOptions(features = "src\\test\\resources\\com.automationChallenge.cucumber.feature\\AutoChallenge.feature",
format = {"pretty", "json:target/cucumber-json-reports/automationChallenge.json"},
glue = {"com.automationChallenge.cucumber.stepDefinition"},
tags = {"~@wip", "~@skip"},
monochrome = true)

public class AutomationChallengeTest extends AbstractTestNGCucumberTests{
 
}