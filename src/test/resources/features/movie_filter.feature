Feature: Filter movies by rating
  As a concerned parent
  So that I can quickly browse movies appropriate for my family
  I want to see only movies with a chosen rating

  Background:
    Given a movie "Men In Black" rated "PG-13" released in 1997 is in the catalog
    And a movie "Alien" rated "R" released in 1979 is in the catalog

  Scenario: Happy path - only the chosen rating is shown
    # TODO 5.1 When: what the parent does on screen 2 of the Lo-Fi
    # TODO 5.2 Then: the movie the parent must see
    # TODO 5.3 And: the movie the parent must not see

  Scenario: Sad path - no movie has the chosen rating
    # TODO 5.4 When: choose a rating that no movie in the Background has
    # TODO 5.5 Then: what the parent sees when no movie matches

Scenario: Happy path - only the chosen rating is shown
    When I filter movies by rating "PG-13"
    Then I should see "Men In Black"
    And I should not see "Alien"
Scenario: Sad path - no movie has the chosen rating
    When I filter movies by rating "G"
    Then I should see no movies