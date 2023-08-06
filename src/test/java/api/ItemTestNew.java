package api;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemTestNew extends BaseApiTest{

    private String idItem = null;


    @Test
    @Order(1)
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
    @Order(2)
    @Tag("Items")
    public void getItem(){
        requests.getItem(idItem)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .body("status", is("ok"));

    }

    @Test
    @Order(3)
    @Tag("Items")
    public void deleteItem(){
        requests.deleteItem(idItem)
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .body("status", is("ok"));
    }

    private static Stream<Arguments> items() {
        return Stream.of(
                Arguments.of(new Items("Pants", "test", "description", "RED", 44, 700, "dress")), // тест кейс 1
                Arguments.of(new Items("Pants", "test", "description", "RED", 44, 700, "dress")) // тест кейс 2
        );
    }

    @ParameterizedTest
    @MethodSource("items")
    public void createItemTest(Items expectedItems) {
        successfulRequests.createItem(expectedItems);
        Items actualItem = successfulRequests.getItem(idItem);
        softly.assertThat(actualItem).isEqualTo(expectedItems);
    }
}
