Feature: Scrollable Tabs Navigation

  @Regression @ScrollableTabs @ReinstallApp
  Scenario: Navigating to the last tab in Scrollable Tabs and verifying Tab 30
    Given the user navigates to the following menu
      | MenuItem      |
      | Views         |
    Given the user scrolls to "Tabs" menu
    Given the user navigates to the following menu
      | MenuItem      |
      | 5. Scrollable |
    And the user clicks on the last tab
    Then the opened tab information should belong to "Tab 30"
