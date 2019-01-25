package utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RawToJsonConverter {
	
	public static JsonPath rawToJson(Response res)
	{
		String StringResponse = res.asString();
		JsonPath jsonpath = new JsonPath(StringResponse);
		return jsonpath;
		
	}

}
