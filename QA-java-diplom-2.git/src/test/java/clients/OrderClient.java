package clients;

import io.restassured.response.Response;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class OrderClient {
    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site/api";
    public Response getIngredients() {
        return given()
                .baseUri(BASE_URI)
                .when()
                .get("/ingredients");
    }

    public Response createOrder(String[] ingredients, String token) {
        Map<String, Object> body = new HashMap<>();
        body.put("ingredients", ingredients);

        var request = given()
                .baseUri(BASE_URI)
                .header("Content-type", "application/json");

        if (!token.isEmpty()) {
            request.header("Authorization", token);
        }

        return request
                .body(body)
                .when()
                .post("/orders");
    }

    public Response getUserOrders(String token) {
        if (token.isEmpty()) {
            return given()
                    .baseUri(BASE_URI)
                    .when()
                    .get("/orders");
        } else {
            return given()
                    .baseUri(BASE_URI)
                    .header("Authorization", token)
                    .when()
                    .get("/orders");
        }
    }
}
