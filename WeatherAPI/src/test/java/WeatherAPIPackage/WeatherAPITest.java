package WeatherAPIPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherAPITest {

    String apiKey = "Your API Key";
    String city = "Bengaluru";  
    String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

    @Test(priority = 1) 
    public void testStatusCode() {
    	 RestAssured.useRelaxedHTTPSValidation();
        Response response = RestAssured.get(url);
        System.out.println("Status Code: " + response.getStatusCode());
        assertEquals(200, response.getStatusCode(), "Expected status code to be 200");
    }

    @Test(priority = 2)  
    public void testCityName() {
        Response response = RestAssured.get(url);
        RestAssured.useRelaxedHTTPSValidation();
        String actualCity = response.jsonPath().getString("name");
        System.out.println("City Name: " + actualCity);
        assertEquals(city, actualCity, "City name in the response should match the input city name");
    }

    @Test(priority = 3) 
    public void testTemperatureExists() {
    	 RestAssured.useRelaxedHTTPSValidation();
        Response response = RestAssured.get(url);
        Object temp = response.jsonPath().get("main.temp");
        System.out.println("Temperature: " + temp);
        assertNotNull(temp, "Temperature data should exist in the response");
    }

    @Test(priority = 4) 
    public void testWeatherDescriptionExists() {
    	 RestAssured.useRelaxedHTTPSValidation();
        Response response = RestAssured.get(url);
        String description = response.jsonPath().getString("weather[0].description");
        System.out.println("Weather Description: " + description);
        assertNotNull(description, "Weather description should exist in the response");
    }

    @Test(priority = 5)  
    public void testHumidityExists() {
    	 RestAssured.useRelaxedHTTPSValidation();
        Response response = RestAssured.get(url);
        Integer humidity = response.jsonPath().getInt("main.humidity");
        System.out.println("Humidity: " + humidity);
        assertNotNull(humidity, "Humidity value should exist in the response");
        assertTrue(humidity >= 0 && humidity <= 100, "Humidity should be between 0 and 100");
    }

    @Test(priority = 6) 
    public void testWindSpeedExists() {
    	 RestAssured.useRelaxedHTTPSValidation();
        Response response = RestAssured.get(url);
        Float windSpeed = response.jsonPath().getFloat("wind.speed");
        System.out.println("Wind Speed: " + windSpeed);
        assertNotNull(windSpeed, "Wind speed should exist in the response");
        assertTrue(windSpeed >= 0, "Wind speed should be a positive value");
    }
}
