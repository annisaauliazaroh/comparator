package com.example.comparator;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.example.comparator"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
