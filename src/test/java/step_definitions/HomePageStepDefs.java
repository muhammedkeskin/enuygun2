package step_definitions;

import utilities.ConfigurationReader;
import utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.HomePageSteps;

public class HomePageStepDefs extends HomePageSteps {

    @Given("Launch Browser")
    public void launch_browser() {
        Driver.getDriver();
    }
    @Given("The user navigates to Home Page")
    public void the_user_navigates_to_home_page() {
        String url = ConfigurationReader.get("url");
        Driver.getDriver().get(url);
    }
    @Given("Fill the route from city: {string} to city {string} on Home Page")
    public void fill_the_route_from_city_to_city_on_home_page(String origin, String destination) {
        selectOrigin(origin);
        selectDestination(destination);
    }
    @Given("Choose depart date day: {string}, month: {string}, and year: {string} on Home Page")
    public void choose_depart_date_day_month_and_year_on_home_page(String day, String month, String year) {
        selectDepartDate(day, month ,year);
    }
    @Given("Choose return date day: {string}, month: {string}, and year: {string} on Home Page")
    public void choose_return_date_day_month_and_year_on_home_page(String day, String month, String year) {
        selectReturnDate(day, month ,year);
    }
    @Given("Choose the non-stop flight checkbox as true or false: set it to {string} on the Home Page")
    public void choose_the_non_stop_flight_checkbox_as_true_or_false_set_it_to_on_the_home_page(String string) {
        chooseNonStopFlight(string);
    }
    @Given("Select passenger types: adults: {int}, children: {int}, babies: {int}, and select the ticket class as {string} on Home Page")
    public void select_passenger_types_adults_children_babies_and_select_the_ticket_class_as_on_home_page(Integer adultsCount, Integer childrenCount, Integer infantsCount, String cabinType) {
        selectPassengersCounts(adultsCount, childrenCount, infantsCount)
                .selectCabinType(cabinType);
    }
    @When("User clicks the search button on the Home Page")
    public void user_clicks_the_search_button_on_the_home_page() {
        searchForResults();
    }
    @Then("User should be redirected to the Results page")
    public void user_should_be_redirected_to_the_results_page() {
        verifyThatNavigatedToResultsPage();
    }
    @Then("Results should display non-stop flights")
    public void results_should_display_non_stop_flights() {
        resultsShouldBeOnlyNonStopFlights();
    }
}
