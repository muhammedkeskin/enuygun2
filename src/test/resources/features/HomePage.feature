@enuygun
  Feature: HomePage

    Background:
      Given Launch Browser

    Scenario: Selecting Ticket

      Given The user navigates to Home Page
      And Fill the route from city: "İstanbul" to city "Antalya" on Home Page
      And Choose depart date day: "26", month: "Mart", and year: "2024" on Home Page
      And Choose return date day: "1", month: "Nisan", and year: "2024" on Home Page
      And Choose the non-stop flight checkbox as true or false: set it to "true" on the Home Page
      And Select passenger types: adults: 1, children: 1, babies: 0, and select the ticket class as "Economy" on Home Page
      When User clicks the search button on the Home Page
      Then User should be redirected to the Results page
      And Results should display non-stop flights

