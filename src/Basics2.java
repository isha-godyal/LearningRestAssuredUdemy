import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
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
				.body("{\r\n" + "\r\n" + "    \"location\":{\r\n" + "\r\n" + "        \"lat\" : -38.383494,\r\n"
						+ "\r\n" + "        \"lng\" : 33.427362\r\n" + "\r\n" + "    },\r\n" + "\r\n"
						+ "    \"accuracy\":50,\r\n" + "\r\n" + "    \"name\":\"Rahul SHetty Academy\",\r\n" + "\r\n"
						+ "    \"phone_number\":\"(+91) 983 893 3937\",\r\n" + "\r\n"
						+ "    \"address\" : \"29, side layout, cohen 09\",\r\n" + "\r\n"
						+ "    \"types\": [\"shoe park\",\"shop\"],\r\n" + "\r\n"
						+ "    \"website\" : \"http://google.com\",\r\n" + "\r\n"
						+ "    \"language\" : \"French-IN\"\r\n" + "\r\n" + "}\r\n" + "")
				.when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("server", "Apache/2.4.41 (Ubuntu)");
	}

}
