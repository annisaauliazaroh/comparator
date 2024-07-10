Feature: Compare API responses

  Scenario: Compare API responses from two files
    Given the URLs are read from "src/test/resources/urls1.txt" and "src/test/resources/urls2.txt"
    When the API responses are compared
    Then the results should be displayed
