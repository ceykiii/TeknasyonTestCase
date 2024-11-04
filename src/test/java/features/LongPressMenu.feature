Feature: Long Press Context Menu Validation

  @Regression @LongPress
  Scenario: Verify that Menu A and Menu B appear when long pressing the "long press me" button
    Given the user navigates to the following menu
      | MenuItem       |
      | App            |
      | Fragment       |
      | Context Menu   |
    When the user long presses the "long press" me button
    Then the "Menu A" and "Menu B" options should be visible
