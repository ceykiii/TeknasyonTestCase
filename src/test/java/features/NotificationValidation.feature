Feature: Notification Validation

  @Regression @Notify
  Scenario: Verify the functionality of Show Notification button and notification details
    Given the user navigates to the following menu
      | MenuItem          |
      | App               |
      | Notification      |
      | IncomingMessage   |
    When the user clicks on the "Show Notification" button
    When the user opens the Notification Bar
    And the user clicks on the notification
    Then the notification detail should open
    And the text in the notification detail should match the notification in the Notification Bar
