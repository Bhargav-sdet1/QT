package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;
import java.util.Map;

public class GetCookies {

	@Test
	void getCookies() {
		
		Response res=given()
		.when().get("https://www.google.com/");
		
		//get single cookie
		String cookie_value=res.getCookie("AEC");
		System.out.println(cookie_value);
		//Get multiple cookies
		Map<String, String> cookies=res.getCookies();
		//System.out.println(cookies.keySet());
		for(String k:cookies.keySet())
		{
			String cookies_value=res.getCookie(k);
			System.out.println(k+"  "+cookies_value);
		}
		
	}
}
