Feature: Game
  Scenario: Clear the game
    Given a board
    And number of players
    When the player wants to
    Then clear the game

    Scenario: Game Victory
      Given a game
      And a player
      When the robot is on the CheckPoint tile
      Then player wins



