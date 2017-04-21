package api;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by angmark on 4/20/2017.
 */
public class APITesting {
    public static Response response;
    public static String jsonAsString;
    public String airBNBLogin(String requestBody) {
        response = given().
               contentType("application/json").
                //body(returnParameters(appName))
                body(requestBody).
        when().
                post("https://api.airbnb.com/v1/authorize").
        then().
               // body(containsString("\"error\":\"unknown_error\"")).
               // body(containsString("\"error_message\":\"Invalid email or password. Please try again.\"")).
               // statusCode(400).
                extract().response();

        jsonAsString = response.asString();
        System.out.println(jsonAsString);
        return jsonAsString;
    }
}

