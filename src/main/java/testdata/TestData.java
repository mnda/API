package testdata;

/**
 * Created by kulasi on 2017-04-21.
 */
public class TestData {
    public final class Login {
        public static final String API_KEY = "3092nxybyb0otqw18e8nh5nty";
        public static final String LOGIN_END_POINT = "https://api.airbnb.com/v1/authorize";
        public static final String CONTENT_TYPE = "application/json";


        public static final String GOOGLE_INVALID_LOGIN_PARAMS =
                "{" +
                "\"client_id\":\"" + API_KEY + "\"," +
                "\"currency\":\"USD\"," +
                "\"locale\":\"en-US\"," +
                "\"assertion_type\":\"https://www.googleapis.com/oauth2/v1/userinfo\"," +
                "\"assertion\":\"va29.rgKq-cvJJ6IetZLecDvv2gxJ92tPYf5kEtL_PS98cEc5x1240n2aelp4uZ22xdWsLu2e\"," +
                "\"prevent_account_creation\":\"true\"" +
                 "}";

        public static final String FB_INVALID_LOGIN_PARAMS =
                "{" +
                        "\"client_id\":\"" + API_KEY + "\"," +
                        "\"currency\":\"USD\"," +
                        "\"locale\":\"en-US\"," +
                        "\"assertion_type\":\"https://graph.facebook.com/me\"," +
                        "\"assertion\":\"CAAAAIEMtwcwBAMTO70riSczKIgT3Nv0EnaZBWmObwt914WAJYRsxZAekHZBLnpqOauZAZATjpmZB8rQF58GlSK5mjX1RbrSXnS7OjkPhqjjKcArd6sDAz83V8zltWogJMsosYJHt7AIz60XTetwUiOmz7OS4rBllLvqBDsW1niOZBKKZBweWAdcasedZBNjbNfoVntlWFx7Uc2hpSR9ROWYAWjXqdHoyjkXafceeJsmCuTKDwZCED\"," +
                        "\"prevent_account_creation\":\"true\"" +
                        "}";


        public static final String EMAIL_SUSPENDED_LOGIN_PARAMS =
                "{" +
                        "\"client_id\":\"" + API_KEY + "\"," +
                        "\"currency\":\"USD\"," +
                        "\"locale\":\"en-US\"," +
                        "\"grant_type\":\"password\"," +
                        "\"username\":\"airbnbdev@gmail.com\"," +
                        "\"password\":\"asdf1234\"" +
                        "}";

        public static final String EMAIL_INVALID_EMAIL_LOGIN_PARAMS =
                "{" +
                        "\"client_id\":\"" + API_KEY + "\"," +
                        "\"currency\":\"USD\"," +
                        "\"locale\":\"en-US\"," +
                        "\"grant_type\":\"password\"," +
                        "\"username\":\"wrong@gmail.com\"," +
                        "\"password\":\"asdf1234\"" +
                        "}";

        public static final String EMAIL_INVALID_PASSWORD_LOGIN_PARAMS =
                "{" +
                        "\"client_id\":\"" + API_KEY + "\"," +
                        "\"currency\":\"USD\"," +
                        "\"locale\":\"en-US\"," +
                        "\"grant_type\":\"password\"," +
                        "\"username\":\"airbnbde@gmail.com\"," +
                        "\"password\":\"wrong\"" +
                "}";

    }

    public final class TestLoginExpectedResults{
        public static final String INVALID_CREDENTIALS_RESPONSE = "{\"error_code\":400,\"error\":\"unknown_error\",\"error_message\":\"Invalid email or password. Please try again.\"}";
        public static final String COULD_NOT_AUTHENTICATE_RESPONSE = "{\"error_code\":401,\"error\":\"third_party_authorization\",\"error_message\":\"Could not authenticate with the remote service\"}";
        public static final String SUSPENDED_ACCOUNT_RESPONSE = "{\"error_code\":401,\"error\":\"suspended_state\",\"error_message\":\"We've temporarily disabled your account. Please email us at account.inquiry@airbnb.com to continue.\"}";
    }
}
