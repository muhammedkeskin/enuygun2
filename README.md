# Enuygun Test Automation with Cucumber

This project demonstrates automated testing of a user journey on the Enuygun website using Cucumber, Selenium, and Java 21.

## Prerequisites

- Java Development Kit (JDK 21)
- Maven
- Browser Drivers (ChromeDriver, GeckoDriver)

## Setup

1. Clone the repository: `git clone https://github.com/muhammedkeskin/enuygun2`
2. Install dependencies: `mvn clean install`

## Running Tests

1. Open the terminal/command prompt in the project directory.
2. Run the tests using Maven: `mvn test`

## Scenario

The test scenario covered in this project includes:

1. Given The user navigates to Home Page
2. And Fill the route from city: "İstanbul" to city "Antalya" on Home Page
3. And Choose depart date day: "26", month: "Mart", and year: "2024" on Home Page
4. And Choose return date day: "1", month: "Nisan", and year: "2024" on Home Page
5. And Choose the non-stop flight checkbox as true or false: set it to "true" on the Home Page
6. And Select passenger types: adults: 1, children: 1, babies: 0, and select the ticket class as "Economy" on Home Page
7. When User clicks the search button on the Home Page
8. Then User should be redirected to the Results page
9. And Results should display non-stop flights
    
## Project Structure

The project follows the Page Object Model (POM) design pattern for better organization and maintainability of test code. It includes the following packages:

- `pages`: Contains Page Object classes that define web element locators on pages.
- `runners`: Contains Cucumber runner classes (`CukesRunner` and `FailedTestRunner`) to execute the feature files.
- `step_definitions`: Contains Cucumber step definition classes that map the Gherkin steps to Java methods.
- `steps`: Contains methods that implement the test steps.
- `utils`: Contains utility classes for page utils, configuration reading, and Driver(WebDriver setup).

## Configuration

Browser configuration and other settings can be customized in the `configuration.properties`.

## Reporting

Test reports are generated using the default Cucumber HTML report plugin. After running tests, the report can be found at `target/enuygun-html-reports.html`.

## Notes

- Please make sure to have the appropriate browser drivers (ChromeDriver, GeckoDriver) installed and added to the system's PATH.
- You can modify the scenario or add new ones as needed in the feature files located in the `src/test/resources` directory.
