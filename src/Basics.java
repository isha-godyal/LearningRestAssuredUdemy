import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Basics {

	public static void main(String[] args) {

		//validate if ADD Place API is working as expected
		
		//given - all input details
		//when - Submit the API --> resource,http method
		//Then - validate the response
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\r\n"
				+ "    \"location\":{\r\n"
				+ "\r\n"
				+ "        \"lat\" : -38.383494,\r\n"
				+ "\r\n"
				+ "        \"lng\" : 33.427362\r\n"
				+ "\r\n"
				+ "    },\r\n"
				+ "\r\n"
				+ "    \"accuracy\":50,\r\n"
				+ "\r\n"
				+ "    \"name\":\"Rahul SHetty Academy\",\r\n"
				+ "\r\n"
				+ "    \"phone_number\":\"(+91) 983 893 3937\",\r\n"
				+ "\r\n"
				+ "    \"address\" : \"71 Summer Walk, USA\",\r\n"
				+ "\r\n"
				+ "    \"types\": [\"shoe park\",\"shop\"],\r\n"
				+ "\r\n"
				+ "    \"website\" : \"http://google.com\",\r\n"
				+ "\r\n"
				+ "    \"language\" : \"French-IN\"\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "").when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200);
	}

}
