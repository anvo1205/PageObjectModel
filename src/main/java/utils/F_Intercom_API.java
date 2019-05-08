package utils;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Utils;

public class F_Intercom_API {
	
	/**
	 * Method name : callIntercomAPI 
	 * Description : This method will set API
	 * authentication, insert parameters of request and send GET request 
	 * Accept : String (API based Url, API token) 
	 * Return : JSONArray (an array of Intercom events)
	 */
	public JSONArray callIntercomAPI(String userEmail) throws JSONException {
		RestAssured.baseURI = Utils.getValueFromPropertiesFile("intercom_api_base_url");
		RequestSpecification request = RestAssured.given()
				.header(new Header("Authorization", "Bearer " + Utils.getValueFromPropertiesFile("intercom_api_token")))
				.accept("application/json");
		request.params("type", "user");
		request.params("email", userEmail);
		Response response = request.get();
		JSONObject data = new JSONObject(response.getBody().asString());
		return data.getJSONArray("events");
	}
	
	/**
	 * Method name : callIntercomAPI 
	 * Description : This method will call intercom API,
	 * and check if number of events generated until timeout 
	 * Accept : String (API based Url, API token) 
	 * Return : JSONArray (an array of Intercom events)
	 * @throws InterruptedException 
	 * @throws JSONException 
	 */
	public JSONArray callIntercomAPI(String userEmail, int numEvents) throws InterruptedException, JSONException {
		RestAssured.baseURI = Utils.getValueFromPropertiesFile("intercom_api_base_url");
		RequestSpecification request = RestAssured.given()
				.header(new Header("Authorization", "Bearer " + Utils.getValueFromPropertiesFile("intercom_api_token")))
				.accept("application/json");
		request.params("type", "user");
		request.params("email", userEmail);
		Response response = request.get();
		JSONObject data = new JSONObject(response.getBody().asString());
		for (int i = 0; i < 10; i++)
		{
			if (data.getJSONArray("events").length() < numEvents)
			{
				Thread.sleep(3000);
				response = request.get();
				data = new JSONObject(response.getBody().asString());
			}
			else
			{
				break;
			}
		}
		return data.getJSONArray("events");
	}
	
	/*
	 * Method name : callIntercomAPI 
	 * Description : This method will call intercom API and filter events by created date
	 * Return : JSONArray (an array of Intercom events)
	 */
	public JSONArray callIntercomAPI(String userEmail, Date createdAfter) throws JSONException {
		RestAssured.baseURI = Utils.getValueFromPropertiesFile("intercom_api_base_url");
		RequestSpecification request = RestAssured.given()
				.header(new Header("Authorization", "Bearer " + Utils.getValueFromPropertiesFile("intercom_api_token")))
				.accept("application/json");
		request.params("type", "user");
		request.params("email", userEmail);
		Response response = request.get();
		JSONObject data = new JSONObject(response.getBody().asString());
		JSONArray events = new JSONArray();
		JSONArray fullEvents = data.getJSONArray("events");
		for (int i = 0; i < fullEvents.length(); i++)
		{
			Long createdDate = fullEvents.getJSONObject(i).getLong("created_at");
			if (Utils.convertUnixTimeToCalendarDate(createdDate).after(createdAfter))
			{
				events.put(fullEvents.getJSONObject(i));
			}
		}
		return events;
	}

	/**
	 * Method name : verifyListEventNames 
	 * Description : This method will compare 2 lists of event names 
	 * Accept : List<String> (actual & expected event names)
	 * Return : boolean
	 */
	public boolean verifyListEventNames(List<String> expected, List<String> actual) {
		Collections.sort(expected);
		Collections.sort(actual);
		if (expected.equals(actual)) {
			return true;
		} else {
			System.out.println("expected: " + expected.size() + " events");
			System.out.println("actual: " + actual.size() + " events");
			System.out.println("events generated are:");
			for (int i = 0; i < actual.size(); i++) {
				System.out.println("event[" + i + "]: " + actual.get(i));
			}
			return false;
		}
	}
	
	/**
	 * Method name : verifyListEventNames 
	 * Description : This method will compare 2 lists of event names 
	 * Accept : List<String> (actual & expected event names)
	 * Return : boolean
	 */
	public boolean verifyEventProperty(JSONObject event, String propertyName, String propertyValue) throws JSONException {
		JSONObject metadata = event.getJSONObject("metadata");
		String actualValue = metadata.getString(propertyName).toString();
		if (actualValue.equalsIgnoreCase(propertyValue))
		{
			return true;
		}
		else
		{
			System.out.println(propertyName + " is incorrect!");
			System.out.println("Actual value: " + actualValue);
			System.out.println("Expected value: " + propertyValue);
			return false;
		}
		
	}

	/**
	 * Method name : getEventByName 
	 * Description : This method will get list of event
	 * names from arrays 
	 * Accept : JSONArray, String 
	 * Return : JSONObject
	 */
	public JSONObject getEventByName(JSONArray events, String eventName) throws JSONException {
		JSONObject event = null;
		for (int i = 0; i < events.length(); i++) {
			event = events.getJSONObject(i);
			if (event.getString("event_name").equalsIgnoreCase(eventName)) {
				break;
			}
		}
		return event;
	}
	
	/**
	 * Method name : getEventByPropertyName 
	 * Description : This method will get event name by property name
	 * Accept : JSONArray, String 
	 * Return : JSONObject
	 */
	public JSONObject getEventByPropertyName(JSONArray events, String eventName, String propertyName) throws JSONException {
		JSONObject event = null;
		for (int i = 0; i < events.length(); i++) {
			event = events.getJSONObject(i);
			if (event.getString("event_name").equalsIgnoreCase(eventName)) {
				String metadata = event.get("metadata").toString();
				if (metadata.contains(propertyName))
				{
					break;
				}
			}
		}
		return event;
	}
	
	/**
	 * This method will verify event by property value
	 * in case events have same name and property name
	 * but different property values
	 * @param JSONArray: events
	 * @param String: eventName
	 * @param String: proName
	 * @param String: proValue
	 * @throws JSONException
	 */
	public boolean verifyEventByPropertyValue(JSONArray events, String eventName, String proName, String proValue) throws JSONException
	{
		boolean result = false;
		for (int i = 0; i < events.length(); i++)
		{
			JSONObject event = events.getJSONObject(i);
			if (event.getString("event_name").equalsIgnoreCase(eventName))
			{
				String value = event.getJSONObject("metadata").getString(proName);
				if(value.equalsIgnoreCase(proValue))
				{
					result = true;
					break;
				}
			}
		}
		if(!result)
		{
			System.out.println(eventName + " event with property value " + proValue + " does not exist!");
		}
		return result;
	}

}
