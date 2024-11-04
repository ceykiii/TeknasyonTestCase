Feature: Hide and Show Buttons

  @Regression @HideShow
  Scenario: Verify the functionality of Hide and Show buttons and text box visibility
    Given the user navigates to the following menu
      | MenuItem       |
      | App            |
      | Fragment       |
      | Hide and Show  |
    Then the user should see two Hide buttons and two text boxes on the screen
    When the user clicks on the second Hide button
    Then the second text box should be hidden and the button text should be "Show"
    When the user clicks on the Show button
    Then the second text box should reappear and the button text should be "Hide"
