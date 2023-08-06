package api;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;

import static org.hamcrest.Matchers.is;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemTestZadanie2 extends BaseApiTest{

    private String idItem = null;


    @Test
    @Order(1)
    @Tag("Items")
    public void searchAllItems(){
        requests.searchAllItems()
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .body("status", is("ok"));
    }


    @Test
    @Order(2)
    @Tag("Items")
    public void createItem(){
        Items item = new Items("Pants", "test", "description", "RED", 44, 700, "dress");
        idItem = requests.createItem(item)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .body("status", is("ok"))
                .extract().path("result.id");
        System.out.println(idItem);
    }

    @Test
    @Order(3)
    @Tag("Items")
    public void updateItem(){
        Items item = new Items("Pants", "test", "description", "BLUE", 44, 800, "dress");
        requests.updateItem(item, idItem)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .body("status", is("ok"));
    }

    @Test
    @Order(4)
    @Tag("Items")
    public void getItem(){
        requests.getItem(idItem)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .body("status", is("ok"));

    }

    @Test
    @Order(5)
    @Tag("Items")
    public void deleteItem(){
        requests.deleteItem(idItem)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .body("status", is("ok"));
    }
}
