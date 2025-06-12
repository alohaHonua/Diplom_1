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

public class OrderTests {
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
    }

    @Test
    @DisplayName("Создание заказа с авторизацией и ингредиентами")
    public void createOrderWithAuthAndIngredientsTest() {
        Response ingredientsResponse = orderClient.getIngredients();
        String ingredient = ingredientsResponse.then()
                .extract().path("data[0]._id");

        Response response = orderClient.createOrder(new String[]{ingredient}, token);
        checkSuccessfulOrderCreation(response);
    }

    @Test
    @DisplayName("Создание заказа без авторизации")
    public void createOrderWithoutAuthTest() {
        Response ingredientsResponse = orderClient.getIngredients();
        String ingredient = ingredientsResponse.then()
                .extract().path("data[0]._id");

        Response response = orderClient.createOrder(new String[]{ingredient}, "");
        checkUnauthorizedOrderCreation(response);
    }

    @Test
    @DisplayName("Создать заказ без ингредиентов")
    public void createOrderWithoutIngredientsTest() {
        Response response = orderClient.createOrder(new String[]{}, token);
        checkMissingIngredientsError(response);
    }


    @Test
    @DisplayName("Создание заказа с недопустимым хэшем ингредиентов")
    public void createOrderWithInvalidIngredientTest() {
        Response response = orderClient.createOrder(new String[]{"invalid_hash_123"}, token);
        checkInvalidIngredientError(response);
    }

    @Step("Проверка успешного создания заказа")
    private void checkSuccessfulOrderCreation(Response response) {
        response.then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("name", not(emptyOrNullString()))
                .body("order.number", notNullValue());
    }

    @Step("Проверка несанкционированного создания заказов")
    private void checkUnauthorizedOrderCreation(Response response) {
        response.then()
                .statusCode(200)
                .body("success", equalTo(true));
    }

    @Step("Проверка ошибки отсутствия ингредиентов")
    private void checkMissingIngredientsError(Response response) {
        response.then()
                .statusCode(400)
                .body("success", equalTo(false))
                .body("message", equalTo("Ingredient ids must be provided"));
    }

    @Step("Ошибка проверки недопустимого ингредиента")
    private void checkInvalidIngredientError(Response response) {
        response.then()
                .statusCode(500);
    }

    @After
    public void tearDown() {
        if (token != null) {
            userClient.delete(token);
        }
    }
}