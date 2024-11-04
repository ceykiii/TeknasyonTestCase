Feature: List Dialog Validation

  @Regression @ListDialog
  Scenario: Verify the order and name of the selected element in the list dialog
    Given the user navigates to the following menu
      | MenuItem        |
      | App             |
      | Alert Dialogs   |
    When the user taps on the "List dialog" option
    When the user selects an element from the list dialog
    Then the alert message displays the correct order and name of the selected element
