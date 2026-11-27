package th.ac.cdti.rottenpotatoes.acceptance;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import th.ac.cdti.rottenpotatoes.domain.Movie;
import th.ac.cdti.rottenpotatoes.domain.MovieCatalog;
import th.ac.cdti.rottenpotatoes.domain.Rating;

/** Step definitions for the movie features, run directly against the plain-Java domain. */
public class MovieSteps {

  private final List<Movie> movies = new ArrayList<>();
  private List<String> shown;

  @Given("a movie {string} rated {string} released in {int} is in the catalog")
  public void addMovieToTheCatalog(String title, String label, int year) {
    movies.add(new Movie(title, Rating.fromLabel(label), "", LocalDate.of(year, 1, 1)));
  }
  @Given("the catalog is empty")
  public void theCatalogIsEmpty() {
    movies.clear();
  }
  /** Keeps only the titles, because the Then steps compare titles. */
  @When("I filter movies by rating {string}")
  public void filterMoviesByRating(String label) {
    shown = new MovieCatalog(movies).byRating(Rating.fromLabel(label)).stream()
.map(Movie::title)
.toList();
  }
   /** Asks for every movie, so the limit never hides one. */
  @When("I sort movies newest first")
  public void sortMoviesNewestFirst() {
    shown = new MovieCatalog(movies).newestFirst(movies.size()).stream()
        .map(Movie::title)
        .toList();
  }

  @When("I sort movies alphabetically")
  public void sortMoviesAlphabetically() {
    shown = new MovieCatalog(movies).titlesSorted();
  } 

  @Then("I should see {string}")
  public void shouldSee(String title) {
    assertThat(shown).contains(title);
  }

  @Then("I should not see {string}")
  public void shouldNotSee(String title) {
    assertThat(shown).doesNotContain(title);
  }
  @Then("I should see the titles {string} in that order")
  public void shouldSeeTheTitlesInThatOrder(String titles) {
    assertThat(shown).containsExactly(titles.split(", "));
  }

  @Then("I should see no movies")
  public void shouldSeeNoMovies() {
    assertThat(shown).isEmpty();
  }
}
