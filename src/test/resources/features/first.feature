Feature: Google Search

  Scenario: Search for Kaholo in Google
    When Open Google on your browser
    Then Enter "Kaholo" in the search text box.
    And Verify "Kaholo" in the first result.

  Scenario: Sample fail
    When Open Google on your browser
    Then fail