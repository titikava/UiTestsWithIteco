package api;

import api.request.Requests;
import api.request.SuccessfulRequests;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.commons.lang3.function.Failable;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * BaseApiTest contains API tests setup and data clean up.
 *
 * @author alexpshe
 * @version 1.0
 */
public class BaseApiTest {
    public static Failable idItems;
    protected SoftAssertions softly;
    protected Requests requests;
    protected SuccessfulRequests successfulRequests;

    @BeforeAll
    public static void restAssured() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @BeforeEach
    public void setupTest() {
        requests = new Requests();
        successfulRequests = new SuccessfulRequests();
        softly = new SoftAssertions();
    }
}