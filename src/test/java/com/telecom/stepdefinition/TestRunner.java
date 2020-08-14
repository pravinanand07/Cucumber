package com.telecom.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src//test//resources/Features",
                 glue="com.telecom.stepdefinition",
                 monochrome = true,
                 plugin="html:target/cucumber-html-reports",
                 dryRun=false,
                 tags= {"@smoke","@regression"})



public class TestRunner {

}

