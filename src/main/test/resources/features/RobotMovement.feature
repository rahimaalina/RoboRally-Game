Feature: Robot movement
  Scenario:Successful right movement of robot
    Given robot
    And robot has x_coordinate 0 and y_coordinate is 0 and robot has direction 0
    When the card is a Rightcard
    Then robot has x_coordinate 0 and has y_coordinate 0 and has direction 1

  Scenario:Successful left movement of robot
    Given robot
    When the card is a Leftcard
    Then robot has x_coordinate 0 and has y_coordinate 0 and has direction 3

  Scenario:Successful uturn movement of robot
    Given robot
    When the card is a Ucard
    Then robot has x_coordinate 0 and has y_coordinate 0 and has direction 2

  Scenario:Successful move1 movement of robot
    Given robot
    When the card is a Move
    Then robot has x_coordinate 0 and has y_coordinate 1 and has direction 0


  Scenario: Dead robot
    Given robot
    And robot life
    When robot life is less than 0
    Then robot respawn


  Scenario: Robot coordinates
    Given robot has coordinate initial x
    And robot has coordinate initial y
    And robot has direction
    When after a round
    Then robot has coordinate final x
    And robot has coordinate final y
    And robot has final direction





