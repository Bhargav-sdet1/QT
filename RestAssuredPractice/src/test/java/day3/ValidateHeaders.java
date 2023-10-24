package day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ValidateHeaders {
	int count;
	//@Test
	void validateHeaders()
	{
		given().log().all()
		.when().get("https://www.google.com/")
		.then()
		.header("Content-Encoding", "gzip");
	}
	
	@Test
	void getHeaders() {
		Response res=given().log().all()
		.when().get("https://www.google.com/");
		//get Single header value
		String head=res.getHeader("Content-Type");
		//System.out.println(head);
		//Get all headers
		Headers heads=res.getHeaders();
		for(Header hd:heads) {
			count++;
			System.out.println(hd.getName()+"  "+hd.getValue());
		}
		System.out.println("Headers Count: "+count);
		
		
	}
}
