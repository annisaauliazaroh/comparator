package com.example.comparator;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ComparatorTest {
    private Comparator comparator = new Comparator();

    @Test
    public void testCompareResponses() throws IOException {
        // This will print the comparison results to the console.
        comparator.compareResponses("src/test/resources/urls1.txt", "src/test/resources/urls2.txt");
    }

    @Test
    public void testCompareJsonResponses() {
        String json1 = "{ \"id\": 1, \"name\": \"John Doe\" }";
        String json2 = "{ \"id\": 1, \"name\": \"John Doe\" }";
        String json3 = "{ \"id\": 2, \"name\": \"Jane Doe\" }";

        boolean result1 = comparator.compareJsonResponses(json1, json2);
        boolean result2 = comparator.compareJsonResponses(json1, json3);

        Assert.assertTrue(result1);
        Assert.assertFalse(result2);
    }
    
    @Test
    public void testDifferentJsonStructures() {
        String json1 = "{ \"id\": 1, \"name\": \"John Doe\" }";
        String json2 = "{ \"id\": 1, \"fullname\": \"John Doe\" }";
    
        boolean result = comparator.compareJsonResponses(json1, json2);
    
        Assert.assertFalse(result);
    }
    
    @Test
    public void testLargeNumberOfUrls() throws IOException {
        // Assuming generateLargeUrlFile generates a file with a large number of URLs for testing
        String file1 = "src/test/resources/largeUrls1.txt";
        String file2 = "src/test/resources/largeUrls2.txt";
    
        comparator.compareResponses(file1, file2);
        // Verify performance and correctness manually or by adding further assertions
    }
    
}
