package dashboardAPIs;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OnboardingPartner {
	
	private static String authToken; // Class-level variable to store the token
	private static String orgId;

	public void testOnboardPartnerInfo() {
        // Base URI
        RestAssured.baseURI = "https://devapi.exmyb.com/api/v1/";

        JSONObject requestBody = new JSONObject();

        // Add key-value pairs
        requestBody.put("registered_business_name", "Test Brand Eight");
        requestBody.put("website", "http://www.testbrand8.com");
        requestBody.put("number_of_employees", "201-500");
        requestBody.put("year_of_establishment", 2023);
        requestBody.put("mobile_number", "8798989978");
        requestBody.put("linkedin_url", "https://linkedin.com/testbrand8");
        requestBody.put("description", "This is the description");

        // Nested JSON object for logo
        JSONObject logo = new JSONObject();
        logo.put("filename", JSONObject.NULL);
        logo.put("url", "");
        requestBody.put("logo", logo);

        requestBody.put("poc_name", "Test POC Eight");
        requestBody.put("poc_email", "testpoc8@yopmail.com");
        requestBody.put("poc_number", "78787888");
        requestBody.put("poc_designation", "Manager");
        requestBody.put("hourly_rate", "");
        requestBody.put("country_code", "+91");
        requestBody.put("poc_country_code", "+91");
        requestBody.put("cmmiLevelSelect", "4");
        requestBody.put("brand_name", "Test Brand Eight");
        
        // Sending PUT request
        Response response = RestAssured.given()
                                       .header("Content-Type", "application/json")
                                       .header("Authorization", "Bearer " + authToken)
                                       .header("orgid", orgId)
                                       .body(requestBody.toString())
                                       .put("/vendor/business_profile/new");

        // Print response
        System.out.println("Onboard Response: " + response.getBody().asString());

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 201);
    }
	
	public void testOnboardPartnerServices() {
        // Base URI
        RestAssured.baseURI = "https://devapi.exmyb.com/api/v1/";

        JSONObject requestBody = new JSONObject();

        // Add key-value pairs
        requestBody.put("registered_business_name", "Test Brand Eight");
        requestBody.put("website", "http://www.testbrand8.com");
        requestBody.put("number_of_employees", "201-500");
        requestBody.put("year_of_establishment", 2023);
        requestBody.put("mobile_number", "8798989978");
        requestBody.put("linkedin_url", "https://linkedin.com/testbrand8");
        requestBody.put("description", "This is the description");

        // Nested JSON object for logo
        JSONObject logo = new JSONObject();
        logo.put("filename", JSONObject.NULL);
        logo.put("url", "");
        requestBody.put("logo", logo);

        requestBody.put("poc_name", "Test POC Eight");
        requestBody.put("poc_email", "testpoc8@yopmail.com");
        requestBody.put("poc_number", "78787888");
        requestBody.put("poc_designation", "Manager");
        requestBody.put("hourly_rate", "");
        requestBody.put("country_code", "+91");
        requestBody.put("poc_country_code", "+91");
        requestBody.put("cmmiLevelSelect", "4");
        requestBody.put("brand_name", "Test Brand Eight");
        
        // Sending PUT request
        Response response = RestAssured.given()
                                       .header("Content-Type", "application/json")
                                       .header("Authorization", "Bearer " + authToken)
                                       .header("orgid", orgId)
                                       .body(requestBody.toString())
                                       .put("/vendor/business_profile/new");

        // Print response
        System.out.println("Onboard Response: " + response.getBody().asString());

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 201);
    }
	
	public void testOnboardPartnerAddress() {
        // Base URI
        RestAssured.baseURI = "https://devapi.exmyb.com/api/v1/";

        JSONObject requestBody = new JSONObject();

        // Adding the new "data" object
        JSONObject dataObject = new JSONObject();
        JSONArray serviceIds = new JSONArray();
        serviceIds.put("666be2c9b5e0edd21cb1b367");
        serviceIds.put("666be2c9b5e0edd21cb1b368");
        dataObject.put("service_ids", serviceIds);

        JSONArray customServices = new JSONArray();
        customServices.put("a");
        customServices.put("b");
        dataObject.put("custom_services", customServices);

        requestBody.put("data", dataObject);

        // Sending PUT request
        Response response = RestAssured.given()
                                       .header("Content-Type", "application/json")
                                       .header("Authorization", "Bearer " + authToken)
                                       .header("orgid", orgId)
                                       .body(requestBody.toString())
                                       .put("/vendor/business_profile/new");

        // Print response
        System.out.println("Onboard Response: " + response.getBody().asString());

        // Validate status code
        Assert.assertEquals(response.getStatusCode(), 201);
    }
	
}
