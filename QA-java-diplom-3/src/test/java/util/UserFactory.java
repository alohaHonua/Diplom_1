package util;

import static io.restassured.RestAssured.given;

public class UserFactory {
    public void createTestUser(String email, String password, String name) {
        String requestBody = String.format("{\"email\": \"%s\", \"password\": \"%s\", \"name\": \"%s\"}",
                email, password, name);

        given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .post("https://stellarburgers.nomoreparties.site/api/auth/register")
                .then()
                .statusCode(200);
    }

    public void deleteTestUser(String email, String password) {
        String requestBody = String.format("{\"email\": \"%s\", \"password\": \"%s\"}",
                email, password);

        String token = given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .post("https://stellarburgers.nomoreparties.site/api/auth/login")
                .then()
                .extract()
                .path("accessToken");

        given()
                .header("Authorization", token)
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then()
                .statusCode(202);
    }
}
