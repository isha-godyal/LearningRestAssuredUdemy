import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

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
		 * Scenario 1: Validate the json response body to verify whether scope value in
		 * response is equals to app or not Verify Header value server is equal to
		 * Apache/2.4.41 (ubuntu) or not
		 * 
		 * 
		 * Scenario 2: Add Place and Update with new address
		 * 
		 * Scenario 3:  get place to Validate if 
		 * New Address is present in response
		 * 
		 */
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.AddPlace())
				.when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		//JsonPath is a class which takes string as a input and convert that Json
		//and it will help to pass the json
		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		System.out.println(placeId);
		
		//Update Place
		
		String newAddress = "71 Summer Walk, USA";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"place_id\":\""+placeId+"\",\r\n"
				+ "    \"address\":\""+newAddress+"\",\r\n"
				+ "    \"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Get Place
		//For Get Method we are not sending any body,no header only focus is on Url and query param
		
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1 = new JsonPath(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		
		//compare actualAddress and newAddress value with Assertion
	}

}
