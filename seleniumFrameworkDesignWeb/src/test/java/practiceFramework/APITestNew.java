package practiceFramework;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITestNew {
	
  
	public static void main(String[] args){
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=	given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json").
		then().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();
	System.out.println(response);
	JsonPath js = new JsonPath(response);
	String placeId=js.get("place_id");
	System.out.println(placeId);
	
	
	String newAddress ="Summer Walk, Africa";
	
	given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").
	body("{\r\n" + 
				"\"place_id\":\""+placeId+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").when().put("maps/api/place/update/json").
	then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	
	//Get Place
	
	String responseOfGet=given().log().all().queryParam("key", "qaclick123")
	.queryParam("place_id",placeId)
	.when().get("maps/api/place/get/json").
	then().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println(responseOfGet);
	JsonPath js1=new JsonPath(responseOfGet);
	String address=js1.get("address");
	
	Assert.assertEquals(address,newAddress);
	
	}
   
   

}
