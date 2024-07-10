package com.example.comparator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ComparatorStepDefinitions {
    private Comparator comparator = new Comparator();
    private String file1;
    private String file2;
    private List<String> results;

    @Given("the URLs are read from {string} and {string}")
    public void the_urls_are_read_from_and(String file1Path, String file2Path) {
        this.file1 = file1Path;
        this.file2 = file2Path;
    }

    @When("the API responses are compared")
    public void the_api_responses_are_compared() throws IOException {
        results = comparator.compareResponses(file1, file2);
    }

    @Then("the results should be displayed")
    public void the_results_should_be_displayed() {
        // Verify the results
        assertTrue(results.size() > 0, "Results should not be empty");
        for (String result : results) {
            System.out.println(result);
            assertTrue(result.contains("equals") || result.contains("not equals"), "Result should contain 'equals' or 'not equals'");
        }
    }
}
