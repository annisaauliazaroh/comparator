package com.example.comparator;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class HttpClientTest {
    private HttpClient httpClient = new HttpClient();

    @Test
    public void testReadUrlsFromFile() throws IOException {
        List<String> urls = httpClient.readUrlsFromFile("src/test/resources/urls1.txt");
        Assert.assertEquals(urls.size(), 2);
        Assert.assertEquals(urls.get(0), "https://reqres.in/api/users/1");
        Assert.assertEquals(urls.get(1), "https://reqres.in/api/users/2");
    }

    @Test
    public void testSendRequest() throws IOException {
        String response = httpClient.sendRequest("https://reqres.in/api/users/1");
        Assert.assertNotNull(response);
        Assert.assertTrue(response.contains("\"id\": 1"));
    }
}
