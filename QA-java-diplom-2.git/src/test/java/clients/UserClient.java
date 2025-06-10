package clients;

import io.restassured.response.Response;
import models.User;

import static io.restassured.RestAssured.given;

public class UserClient {
    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site/api";

    public Response create(User user) {
        return given()
                .baseUri(BASE_URI)
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post("/auth/register");
    }

    public Response login(User user) {
        return given()
                .baseUri(BASE_URI)
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post("/auth/login");
    }

    public Response update(User user, String token) {
        return given()
                .baseUri(BASE_URI)
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .body(user)
                .when()
                .patch("/auth/user");
    }

    public Response delete(String token) {
        return given()
                .baseUri(BASE_URI)
                .header("Authorization", token)
                .when()
                .delete("/auth/user");
    }
}
