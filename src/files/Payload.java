package files;

public class Payload {

	public static String AddPlace()
	{
		return "{\r\n"
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
				+ "";
	}
	
	public static String CoursePrice()
	{
		return "{\r\n"
				+ "			   \"dashboard\": {\r\n"
				+ "				    \"purchaseAmount\":1405,\r\n"
				+ "				    \"website\":\"rahulshettyacademy.com\"\r\n"
				+ "				},\r\n"
				+ "				\"courses\": [\r\n"
				+ "				{\r\n"
				+ "				   \"title\":\"Selenium Python\",\r\n"
				+ "				    \"price\": 50,\r\n"
				+ "				    \"copies\": 6\r\n"
				+ "				 },\r\n"
				+ "				{\r\n"
				+ "				    \"title\":\"Cypress\",\r\n"
				+ "				    \"price\": 40,\r\n"
				+ "				    \"copies\": 4\r\n"
				+ "				},\r\n"
				+ "				{\r\n"
				+ "				    \"title\":\"RPA\",\r\n"
				+ "				    \"price\": 45,\r\n"
				+ "				    \"copies\": 10\r\n"
				+ "				},\r\n"
				+ "                {\r\n"
				+ "				    \"title\":\"Appium\",\r\n"
				+ "				    \"price\": 55,\r\n"
				+ "				    \"copies\": 9\r\n"
				+ "				}  \r\n"
				+ "				]\r\n"
				+ "				}";
				
	}
}
