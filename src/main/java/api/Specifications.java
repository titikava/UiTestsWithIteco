package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

/**
 * Specifications contain Rest Assured specifications for basic API requests and responses.
 *
 * @author alexpshe
 * @version 1.0
 */
public class Specifications {
    public io.restassured.specification.RequestSpecification baseRequestSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setBaseUri("http://shop.bugred.ru/api/items/create/");
        return requestSpecBuilder.build();
    }

    public io.restassured.specification.RequestSpecification getRequestSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setBaseUri("http://shop.bugred.ru/api/items/get/");
        return requestSpecBuilder.build();
    }

    public io.restassured.specification.RequestSpecification deleteRequestSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setBaseUri("http://shop.bugred.ru/api/items/delete/");
        return requestSpecBuilder.build();
    }

    public io.restassured.specification.RequestSpecification searchAllRequestSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setBaseUri("http://shop.bugred.ru/api/items/select");
        return requestSpecBuilder.build();
    }

    public io.restassured.specification.RequestSpecification updateRequestSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setBaseUri("http://shop.bugred.ru/api/items/update");
        return requestSpecBuilder.build();
    }
}
