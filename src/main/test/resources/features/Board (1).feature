Feature: Board Initialization

  #difficulty
  Scenario: Initialize a board with different difficulty levels
    Given a board with <number_of_players> player(s) and difficulty level <difficulty>
    When the board is initialized
    Then the board should be populated correctly based on specified difficulty



  Scenario: Victory
    Given a board



   Scenario: Out of bounds
     Given a board
     When the board is initialized
     And the robot moves out of the boundaries
     Then robot stays in board