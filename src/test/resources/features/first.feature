Feature: Google Search

  @pass
  Scenario: Search for Kaholo in Google
    When Open Google on your browser
    Then Enter "Kaholo" in the search text box.
    And Verify "Kaholo" in the first result.

  @pass
  Scenario: Search for Cucumber in Google
    When Open Google on your browser
    Then Enter "Cucumber" in the search text box.
    And Verify "Cucumber" in the first result.