import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import files.Payload;
import files.ReusableMethods;

import static io.restassured.RestAssured.*;

public class Basics2 {

	public static void main(String[] args) throws IOException {

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
		
		//here the response we are getting in string format that we are storing in String response var
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				//Bytes are converted into string and content of the json is comin from external file
				.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Win\\Documents\\addPlace.json"))))  
				.when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		//and this String response var we are parsing it to a json format 
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
		
		JsonPath js1 = ReusableMethods.rawToJson(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		
		//compare actualAddress and newAddress value with Assertion
		
		Assert.assertEquals(actualAddress,"Pacific Ocean");
	}

}
