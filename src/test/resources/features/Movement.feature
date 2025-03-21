Feature:Moving pieces on the board according to the card
  Scenario: Successful execution of right card
    Given a card with "turn right"
    And a board
    And robot with initial coordinates (0, 0)
    And robot initially facing "North"
    When robot executes action
    Then robot with final coordinates (0, 0)
    And robot finally facing "East"

  Scenario: Successful execution of left card
    Given a card with "turn righ"
    And a board
    And robot with initial coordinates (0, 0)
    And robot initially facing "North"
    When robot executes action
    Then robot with final coordinates (0, 0)
    And robot finally facing "West"

  Scenario: Successful execution of move2 card
    Given a card with "move2"
    And a board
    And robot with initial coordinates (0, 0)
    And robot initially facing "North"
    When robot executes action
    Then Robot is at coordinate (0, 2)

  Scenario: Successful execution of move1 card
    Given a card with "move1"
    And a board
    And robot with initial coordinates (0, 0)
    And robot initially facing "North"
    When robot executes action
    Then Robot is at coordinate (0, 1)

  Scenario: Successful execution of u-turn card
    Given a card with "u-turn"
    And a board
    And robot with initial coordinates (0, 0)
    And robot initially facing "North"
    When robot executes action
    Then Robot is at coordinate (0, 0)
    And robot finally facing South
