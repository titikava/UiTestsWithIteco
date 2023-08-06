package api.request;


import api.Items;
import api.Specifications;
import com.google.gson.Gson;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Requests contain base API request without any verification.
 *
 * @author alexpshe
 * @version 1.0
 */
public class Requests {
    private final Specifications specifications;
    private final Gson gson;

    public Requests() {
        this.specifications = new Specifications();
        this.gson = new Gson();
    }

    public Response searchAllItems(){
        return given()
                .spec(specifications.searchAllRequestSpec())
                .body("{\n" +
                        "    \"sql_query\": \"select * from items;\"\n" +
                        "}")
                .post();
    }

    public Response updateItem(Items item, String id){
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", id);
        requestBody.put("name", item.getName());
        requestBody.put("section", item.getSection());
        requestBody.put("description", item.getDescription());
        requestBody.put("color", item.getColor());
        requestBody.put("size", item.getSize());
        requestBody.put("price", item.getPrice());
        requestBody.put("params", item.getParams());
        return given()
                .spec(specifications.updateRequestSpec())
                .body(gson.toJson(requestBody))
                .put();
    }

    public Response createItem(Items item){
        return given()
                .spec(specifications.baseRequestSpec())
                .body(gson.toJson(item))
                .post();
    }

    public Response getItem(String itemId) {
        return given()
                .spec(specifications.getRequestSpec())
                .param("id", itemId)
                .get();
    }

    public Response deleteItem(String itemId){
        return given()
                .spec(specifications.deleteRequestSpec())
                .param("id", itemId)
                .delete();
    }
}
