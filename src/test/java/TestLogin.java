import api.APITesting;
import org.junit.Assert;
import org.testng.annotations.Test;
import testdata.TestData;

/**
 * Created by angmark on 4/20/2017.
 */
public class TestLogin {
    @Test
    public void testGoogleLoginSuccessful() {
        //cannot find valid google auth code
    }

    @Test
    public void testGoogleLoginInvalid() {
        APITesting apitesting = new APITesting();
        String responseBody = apitesting.airBNBLogin(TestData.Login.GOOGLE_INVALID_LOGIN_PARAMS);
        System.out.println("Validate response for invalid login to AirBNB API using invalid google authorization key");
        Assert.assertEquals("Expected and Actual Response does not match",TestData.TestLoginExpectedResults.INVALID_CREDENTIALS_RESPONSE,responseBody);
    }


//    @Test
//    public void testFBLoginSuccessful() {
//        //cannot find valid fb auth code
//    }
//
//    @Test
//    public void testFBLoginInvalid() {
//        APITesting apitesting = new APITesting();
//        String responseBody = apitesting.airBNBLogin(TestData.Login.FB_INVALID_LOGIN_PARAMS);
//        System.out.println("Validate response for invalid login to AirBNB API using invalid fb authorization key");
//        Assert.assertEquals("Expected and Actual Response does not match",responseBody, TestData.TestLoginExpectedResults.COULD_NOT_AUTHENTICATE_RESPONSE);
//    }
//
//
//    @Test
//    public void testEmailLoginSuccessful() {
//        //cannot find valid email and password
//    }
//
//    @Test
//    public void testEmailLoginInvalidPassword() {
//        APITesting apitesting = new APITesting();
//        String responseBody = apitesting.airBNBLogin(TestData.Login.EMAIL_INVALID_PASSWORD_LOGIN_PARAMS);
//        System.out.println("Validate response for  invalid login to AirBNB API using  invalid email and valid password");
//        Assert.assertEquals("Expected and Actual Response does not match",responseBody, TestData.TestLoginExpectedResults.INVALID_CREDENTIALS_RESPONSE);
//    }
//
//    @Test
//    public void testEmailLoginInvalidEmail() {
//        APITesting apitesting = new APITesting();
//        String responseBody = apitesting.airBNBLogin(TestData.Login.EMAIL_INVALID_EMAIL_LOGIN_PARAMS);
//        System.out.println("Validate response for  invalid login to AirBNB API using valid email and invalid password");
//        Assert.assertEquals("Expected and Actual Response does not match",responseBody, TestData.TestLoginExpectedResults.INVALID_CREDENTIALS_RESPONSE);
//    }
//
//    @Test
//    public void testSuspendedEmailLoginInvalid() {
//        APITesting apitesting = new APITesting();
//        String responseBody = apitesting.airBNBLogin(TestData.Login.EMAIL_SUSPENDED_LOGIN_PARAMS);
//        System.out.println("Validate response for suspended login to AirBNB API using suspended email and password");
//        Assert.assertEquals("Expected and Actual Response does not match",responseBody, TestData.TestLoginExpectedResults.SUSPENDED_ACCOUNT_RESPONSE);
//    }


}
