package tests;

import clients.OrderClient;
import clients.UserClient;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class UserOrdersTests {
    private User user;
    private UserClient userClient;
    private OrderClient orderClient;
    private String token;

    @Before
    public void setUp() {
        user = User.getRandomUser();
        userClient = new UserClient();
        orderClient = new OrderClient();
        userClient.create(user);
        token = userClient.login(user)
                .then().extract().path("accessToken");

        Response ingredientsResponse = orderClient.getIngredients();
        String ingredient = ingredientsResponse.then()
                .extract().path("data[0]._id");
        orderClient.createOrder(new String[]{ingredient}, token);
    }

    @Test
    @DisplayName("Получение заказов пользователей с авторизацией")
    public void getUserOrdersWithAuthTest() {
        Response response = orderClient.getUserOrders(token);
        checkSuccessfulOrdersRetrieval(response);
    }

    @Test
    @DisplayName("Получение заказов пользователей без авторизации")
    public void getUserOrdersWithoutAuthTest() {
        Response response = orderClient.getUserOrders("");
        checkUnauthorizedError(response);
    }

    @Step("Проверка успешного получения заказов")
    private void checkSuccessfulOrdersRetrieval(Response response) {
        response.then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("orders", not(empty()))
                .body("total", greaterThan(0))
                .body("totalToday", greaterThan(0));
    }

    @Step("Проверка ошибки авторизации")
    private void checkUnauthorizedError(Response response) {
        response.then()
                .statusCode(401)
                .body("success", equalTo(false))
                .body("message", equalTo("You should be authorised"));
    }

    @After
    public void tearDown() {
        if (token != null) {
            userClient.delete(token);
        }
    }
}
