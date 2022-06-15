import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import files.Payload;

import static io.restassured.RestAssured.*;

public class Basics2 {

	public static void main(String[] args) {

		// validate if ADD Place API is working as expected

		// given - all input details
		// when - Submit the API --> resource,http method
		// Then - validate the response
		/*
		 * Scenario : Validate the json response body to verify whether scope value in
		 * response is equals to app or not Verify Header value server is equal to
		 * Apache/2.4.41 (ubuntu) or not
		 * 
		 */
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.AddPlace())
				.when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("server", "Apache/2.4.41 (Ubuntu)");
	}

}
