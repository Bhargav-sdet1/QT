package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class PostReqUsingPojo {
	@Test(priority=1)
	void createUser() {
		
		Post_pojo pj = new Post_pojo();
		pj.setName("bhargav");
		pj.setJob("Software Test Engineer");
		String courseArr[] = {"C","C++"};
		pj.setCources(courseArr);
		
		given().log().all()
		.contentType("application/json")
		.body(pj)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all();
	}
}
