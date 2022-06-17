import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {

		//create json path
		JsonPath js = new JsonPath(Payload.CoursePrice());      //pass the response to json in string format in JsonPath() as argument
		
		//1. Print number of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//2. Print purchase Amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		//3. Title of first course
		String titleFirstCourse = js.get("courses[0].title");
		System.out.println(titleFirstCourse);
		
		//4. Print All course titles and their respective Prices
		for(int i=0;i<count;i++)
		{
			String courseTitles = js.get("courses["+i+"].title");
			
			 System.out.println(js.get("courses["+i+"].price").toString());
			 
			System.out.println(courseTitles);
		}
		
		//5. Print no of copies sold by RPA Course
		System.out.println(" Print no of copies sold by RPA Course");
		
		for(int i=0;i<count;i++)
		{
			String courseTitles = js.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA"))
			{
				//copies sold
				int copies = js.get("courses["+i+"].copies");
				System.out.println(copies);
				break;
			}
		}
		
	}

}
