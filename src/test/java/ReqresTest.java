import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class ReqresTest {

    @Test
    void getSingleResourceTest() {
        given().
                when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", equalTo(2));
    }

    @Test
    void getListResourceTest() {
        given().
                when()
                .get("https://reqres.in/api/unknown")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", hasSize(6))
                .and()
                .body("data", hasItems(
                        hasEntry("name", "cerulean"),
                        hasEntry("name", "fuchsia rose"),
                        hasEntry("name", "true red"),
                        hasEntry("name", "aqua sky"),
                        hasEntry("name", "tigerlily"),
                        hasEntry("name", "blue turquoise")
                ));
    }

    @Test
    void getSingleResourceNotFoundTest() {
        given().
                when()
                .get("https://reqres.in/api/unknown/23")
                .then()
                .statusCode(404)
                .body("isEmpty()", is(true));
    }

    @Test
    void postCreateTest() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"morpheus\", \"job\": \"leader\"}")
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("name", is("morpheus"));
    }

    @Test
    void patchUpdateTest() {
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"morpheus\", \"job\": \"zion resident\"}")
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name", is("morpheus"))
                .and().body("job", is("zion resident"));
    }
}
