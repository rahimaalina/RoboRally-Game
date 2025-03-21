Feature:Player gets cards
  Scenario:Successful player getting cards
    Given a player
    When game begins
    Then player gets cards

  Scenario:Successful player after picking cards
    Given a player
    When player gets cards
    Then player picks cards

  Scenario:Successful player setting their name
    Given a player
    When game begins
    Then player sets their name

  Scenario:Successful player getting their player id
    Given a player
    When game begins
    Then player gets their playerID


   Scenario: Transforming card strings to card
     Given a player
     When the player gets the cards
     Then the string cards are going to transform to cards