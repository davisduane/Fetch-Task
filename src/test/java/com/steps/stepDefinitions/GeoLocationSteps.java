package com.steps.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GeoLocationSteps {

    private static final String API_KEY = "f897a99d971b5eef57be6fafa0d83239"; // Your actual API key
    private static final String API_URL = "http://api.openweathermap.org/geo/1.0/direct";

    private String location;
    private String zipCode;
    private Response response;

    @Given("I have the location {string}")
    public void i_have_the_location(String location) {
        this.location = location;

    }

    @When("I call the OpenWeather Geocoding API")
    public void i_call_the_open_weather_geocoding_api() {
        if (location != null) {
            response = RestAssured.given()
                    .param("q", location)
                    .param("limit", 1)
                    .param("appid", API_KEY)
                    .when()
                    .get(API_URL);
        } else if (zipCode != null) {
            response = RestAssured.given()
                    .param("zip", zipCode)
                    .param("appid", API_KEY)
                    .when()
                    .get(API_URL);
        }

    }

    @Then("I should receive a valid response with coordinates")
    public void i_should_receive_a_valid_response_with_coordinates() {
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.jsonPath().get("lat[0]"));
        assertNotNull(response.jsonPath().get("lon[0]"));


    }

    @Given("I have the zip code {string}")
    public void i_have_the_zip_code(String zipCode) {
        this.zipCode = zipCode;


    }
}


