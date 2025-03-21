Feature: Tile Types
  Scenario: Robot is on a conveyor belt tile type
    Given a conveyor belt facing direction
    And A robot is on the tile
    When The round ends
    Then the conveyor moves the robot


  Scenario: