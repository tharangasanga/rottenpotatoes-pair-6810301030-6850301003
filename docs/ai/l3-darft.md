# Specification: Movie Filter by Rating

## 1. Overview
This specification defines the movie filtering and listing behavior for Rotten Potatoes so a parent can quickly find age-appropriate movies without opening each movie detail page individually.

## 2. Functional Requirements
- **REQ-01:** The system shall display the full movie list sorted by release date with the newest movies first by default.
- **REQ-02:** The system shall provide five selectable MPAA rating options: `G`, `PG`, `PG-13`, `R`, and `NC-17`.
- **REQ-03:** When a user selects a rating, the system shall display only movies matching that exact rating.
- **REQ-04:** The user shall select only one rating at a time using a single-select dropdown control.
- **REQ-05:** If an invalid rating value is submitted, the system shall reject the input with an error message listing the five allowed ratings (`G`, `PG`, `PG-13`, `R`, `NC-17`).
- **REQ-06:** When no movies match the chosen rating, the system shall return an empty list and display the message "No movies found" without throwing an exception.
- **REQ-07:** The system shall allow the user to clear the active filter and return to the full movie list.
- **REQ-08:** The system shall remember the user's last selected rating in browser local storage across page reloads.
- **REQ-09:** The system shall not require user login, account creation, or collection of any personal data.

## 3. User Stories & Acceptance Criteria

### Story 1: Filter movies by rating
As a parent,
I want to filter the movie list by a chosen rating,
So that I can quickly find movies suitable for my child without checking each movie one by one.

- **AC-1.1:** Given the catalog contains movies with ratings PG-13 and `R`, when the parent filters by `PG-13`, only PG-13 movies are shown.
- **AC-1.2:** Only the five ratings (`G`, `PG`, `PG-13`, `R`, `NC-17`) are available to choose from.
- **AC-1.3:** The filtering operation executes in a single method call on MovieCatalog and completes in under 50ms.
- **AC-1.4:** No login prompt or personal profile input appears before or during filtering.

### Story 2: View newest movies first
As a moviegoer,
I want the full movie list to show the newest movies first,
So that I can immediately see recent releases.

- **AC-2.1:** When viewing the unfiltered movie list, movies are ordered by release date descending.
- **AC-2.2:** Movies with identical release dates are ordered alphabetically by title as a tie-breaker.

### Story 3: Handle empty filter results
As a parent,
I want to see a clear empty state when no movies have my chosen rating,
So that I know the filter worked even when nothing matches.

- **AC-3.1:** When filtering by a rating that has zero matching movies, no movie rows are shown and "No movies found" is displayed.

## 4. Assumptions & Concerns
- **Concern 1:** MPAA rating is a general guideline; suitability for a specific child's age may still depend on content details beyond the rating label.
- **Assumption 1:** Every movie in the catalog already has one valid rating assigned from the five standard values.