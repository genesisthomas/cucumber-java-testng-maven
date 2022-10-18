Feature: Kaholo Alert

  @pass
  Scenario: Verify alert in Kaholo
    When Open kaholo on your browser
    Then Enter "Kaholo" in first name
    And Enter "user" in last name
    And Enter "email" in email
    And Verify alert
    And Take screenshot