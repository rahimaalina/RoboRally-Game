Feature:Executing a card
  Scenario: Successful execution of card
    Given a card
    And a deck
    When shuffle and pick 9 cards
    Then robot execute card
    And print 9 cards picked
    And print deck


