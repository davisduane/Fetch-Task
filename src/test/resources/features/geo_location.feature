Feature: Geolocation API

  @loc
  Scenario: Get coordinates by location name
    Given I have the location "Madison, WI"
    When I call the OpenWeather Geocoding API
    Then I should receive a valid response with coordinates


  @zip
  Scenario: Get coordinates by zip code
    Given I have the zip code "53558"
    When I call the OpenWeather Geocoding API
    Then I should receive a valid response with coordinates