package tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import io.restassured.RestAssured;


public class DeleteBook {
	
	@Test (dataProvider="BookData")
	
	public void verifyDeleteBook(String BookID) throws IOException {

    Base.initialize();
	RestAssured.baseURI= Base.prop.getProperty("BaseURL");
	
	given()
	.header("Content-Type","application/json")
	.body("{\n" + 
			" \n" + 
			"\"ID\" : \""+BookID+"\n" + 
			" \n" + 
			"}\n" + 
			"")
	.when()
	.post("/Library/DeleteBook.php")
	.then()
	.assertThat()
	.statusCode(200);
	
}



@DataProvider(name="BookData")

public Object [][] getData()
{
  return new Object[][] {{"ISBN1123"},{"ISBN2567"},{"ISBN3012"}};
}
  
  
}
