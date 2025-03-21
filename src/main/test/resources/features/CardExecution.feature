Feature:Executing a card
  Scenario: Successful execution of rightcard
    Given a card
    When the card is Rightcard
    Then robot execute card

  Scenario: Successful execution of leftcard
    Given a card
    When the card is Leftcard
    Then robot execute card

  Scenario: Successful execution of move1
    Given a card
    When the card is Moveone card
    Then robot execute card


  Scenario: Successful execution of ucard
    Given a card
    When the card is Ucard
    Then robot execute card

   Scenario: Execution of a card
     Given a card
     When the card is Ucard
     Then the U card is executed


  Scenario: Execution of a card
    Given a card
    When the card is Rightcard
    Then the Right card is executed

  Scenario: Execution of a card
    Given a card
    When the card is Leftcard
    Then the Left card is executed

  Scenario: Execution of a card
    Given a card
    When the card is Movetwo
    Then the Movetwo card is executed





