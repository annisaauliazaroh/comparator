package com.example.comparator;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Comparator {

    private HttpClient httpClient = new HttpClient();

    public List<String> compareResponses(String file1, String file2) throws IOException {
        List<String> urls1 = httpClient.readUrlsFromFile(file1);
        List<String> urls2 = httpClient.readUrlsFromFile(file2);
        List<String> results = new ArrayList<>();

        for (int i = 0; i < Math.min(urls1.size(), urls2.size()); i++) {
            String response1 = httpClient.sendRequest(urls1.get(i));
            String response2 = httpClient.sendRequest(urls2.get(i));
            boolean isEqual = compareJsonResponses(response1, response2);

            if (isEqual) {
                results.add(urls1.get(i) + " equals " + urls2.get(i));
            } else {
                results.add(urls1.get(i) + " not equals " + urls2.get(i));
            }
        }

        return results;
    }

    public boolean compareJsonResponses(String json1, String json2) {
        JSONObject obj1 = new JSONObject(json1);
        JSONObject obj2 = new JSONObject(json2);
        return obj1.similar(obj2);
    }
}
