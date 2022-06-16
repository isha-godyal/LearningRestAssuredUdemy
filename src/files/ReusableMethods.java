package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	
	//converting String into json format
	public static JsonPath rawToJson(String response)
	{
		JsonPath js1 = new JsonPath(response);
		return js1;
		
	}

}
