package api.tests;

import api.models.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BodyToAllureTest {
    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in")
            .setContentType(ContentType.JSON)
            .setBasePath("/api/users")
            .build();

    @Test
    public void bodyTest() {
        User user = User.builder()
                .name("Max")
                .job("QAA")
                .build();

        given()
                .spec(requestSpecification)
                .body(user)
                .when()
                .post()
                .then()
                .log().body()
                .body("name", equalTo("Max"));
    }
}
