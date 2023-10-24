package day2;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreatingPostReqUsingHashMap {

	@Test
	public void postUSingHashMap()
	{
		HashMap hm= new HashMap();
		
		hm.put("name", "bhargav");
		hm.put("phone", "99999");
		hm.put("location", "hyderabad");
		
		String courseArr[]= {"c","java"};
		
		hm.put("cources", courseArr);
		
		given().log().all().contentType("application/json")
		.body(hm)
		.when().post("http://localhost:3000/students")
		.then().statusCode(201)
		.body("name", equalTo("Bhargav"))
		.body("location", equalTo("hyderabad"))
		.body("phone",equalTo("99999"))
		.body("cources[0]", equalTo("c"))
		.header("Content-Type", "application/json");
	}
	
}
