package api.request;

import api.Items;
import org.apache.http.HttpStatus;

/**
 * SuccessfulRequests contain base API requests with status code verification and data serialization.
 *
 * @author alexpshe
 * @version 1.0
 */
public class SuccessfulRequests {
    private final Requests requests;

    public SuccessfulRequests() {
        this.requests = new Requests();
    }

    public void createItem(Items item) {
        requests.createItem(item)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }

    public Items getItem(String itemId) {
        return requests.getItem(itemId)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().body().as(Items.class);
    }

    public Items deleteItem(String itemId) {
        return requests.deleteItem(itemId)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().body().as(Items.class);
    }
}