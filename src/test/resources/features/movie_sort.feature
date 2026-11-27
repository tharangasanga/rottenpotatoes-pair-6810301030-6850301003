Feature: Sort movies
  As a moviegoer
  So that I can find new releases and browse the catalog by name
  I want the movie list sorted newest first or alphabetically

  Scenario: Happy path the newest release comes first
    Given a movie "Alien" rated "R" released in 1979 is in the catalog
    And a movie "Men In Black" rated "PG-13" released in 1997 is in the catalog
    And a movie "Aladdin" rated "G" released in 1992 is in the catalog
    When I sort movies newest first
    Then I should see the titles "Men In Black, Aladdin, Alien" in that order

  Scenario: Sad path the catalog is empty
    Given the catalog is empty
    When I sort movies alphabetically
    Then I should see no movies