package tests;

import java.io.IOException;
import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import io.restassured.RestAssured;

public class AddBook {
	
  @Test (dataProvider="BookData")
  public void verifyAddingBooks(String ISBN, String Aisle) throws IOException {
	  
	    Base.initialize();
		RestAssured.baseURI= Base.prop.getProperty("BaseURL");
		
		given()
		.header("Content-Type","application/json")
		.body("{\n" + 
				"\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\n" + 
				"\"isbn\":\""+ ISBN+",\n" + 
				"\"aisle\":\""+Aisle+",\n" + 
				"\"author\":\"John foe\"\n" + 
				"}\n" + 
				" \n" + 
				"")
		.when()
		.post("/Library/Addbook.php")
		.then()
		.assertThat()
		.statusCode(200);
	  
  }
  
  
  
  @DataProvider(name="BookData")
  
  public Object [][] getData()
  {
	  return new Object[][] {{"ISBN1", "123"},{"ISBN2", "567"},{"ISBN3", "012"}};
  }
  
  
  
}
