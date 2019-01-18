package ru.usetech.pft.velobike.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "classpath:bdd",plugin = {"pretty","html:build/cucumber-report"})
public class SideMenuTest extends AbstractTestNGCucumberTests {

}
