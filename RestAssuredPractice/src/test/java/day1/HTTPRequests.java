package day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTPRequests {

	int id;
	
	@Test
	void getUser()
	{
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
	}
	@Test(priority=1)
	void createUser() {
		id=given().log().all()
		.contentType("application/json")
		.body("{\r\n"
				+ "    \"name\": \"Bhargav\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		//.then()
		//.statusCode(201)
		//.log().all();
	}
	
	@Test(priority=2,dependsOnMethods= {"createUser"})
	void updateUser() {
		
		given().log().all().contentType("application/json")
		.body("{\r\n"
				+ "    \"name\": \"Bhargav Goud\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(200);
	}
	
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void deleteUser() {
		
		given().log().all()
		.when().delete("/api/users/"+id)
		.then().statusCode(204);
	}
	
	
}
