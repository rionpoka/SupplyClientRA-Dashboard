package dashboardAPIs;

import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Authentication {
	
	
	private static String authToken; // Class-level variable to store the token
	private static String orgId;
	
	public void testSignUp() {
        // Base URI
        RestAssured.baseURI = "https://devapi.exmyb.com/api/v1";

        // JSON request payload
        JSONObject requestBody = new JSONObject();
        
        requestBody.put("first_name", "Test User");
        requestBody.put("last_name", "Eleven");
        requestBody.put("email", "testuser11@yopmail.com");
        requestBody.put("password", "123456");
        requestBody.put("country_code", "+91");
        requestBody.put("mobile_number", "9998798977");
        requestBody.put("user_type", "vendor");

        
        // Sending POST request
        Response response = RestAssured.given()
                                       .header("Content-Type", "application/json")
                                       .body(requestBody)
                                       .post("/user/signup");
        
        System.out.println("Request Payload: " + requestBody.toString());
        
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Headers: " + response.getHeaders());

        // Print response
        System.out.println("Response: " + response.getBody().asString());

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 201);

    }
	
	
	public void testValidateEmail() {
        // Base URI
        RestAssured.baseURI = "https://devapi.exmyb.com/api/v1/";

        // JSON request payload
        JSONObject requestBody = new JSONObject();

        // Add key-value pairs to the JSONObject
        requestBody.put("email", "testuser09@yopmail.com");
        requestBody.put("otp", "4171");
        requestBody.put("user_type", "vendor");

        // Sending POST request
        Response response = RestAssured.given()
                                       .header("Content-Type", "application/json")
                                       .body(requestBody)
                                       .post("/validate_email/otp");

        // Print response
        System.out.println("Response: " + response.getBody().asString());

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 201);

    }
	
	
	public void testLoginPartner() {
        // Base URI
        RestAssured.baseURI = "https://devapi.exmyb.com/api/v1/";

        // Create JSONObject
        JSONObject requestBody = new JSONObject();
        
        // Add key-value pairs
        requestBody.put("email", "testuser08@yopmail.com");
        requestBody.put("password", "123456");
        requestBody.put("remember", "true");
        requestBody.put("user_type", "vendor");

        // Sending POST request
        Response response = RestAssured.given()
                                       .header("Content-Type", "application/json")
                                       .body(requestBody.toString())
                                       .post("/user");

        // Print response
        System.out.println("Response: " + response.getBody().asString());

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 201);
        
        // Extract token from the response and store it
        authToken = response.jsonPath().getString("data.access_token");
        orgId = response.jsonPath().getString("data.org_profiles[0].org_id");
        
        Assert.assertNotNull(authToken, "Auth token is null!");
        Assert.assertNotNull(orgId, "Org ID is null!");

    }

}
