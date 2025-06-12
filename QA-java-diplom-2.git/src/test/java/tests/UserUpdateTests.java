package tests;

import clients.UserClient;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class UserUpdateTests {
    private User user;
    private User updatedUser;
    private UserClient userClient;

    @Before
    public void setUp() {
        user = User.getRandomUser();
        updatedUser = User.getRandomUser();
        userClient = new UserClient();
        userClient.create(user);
    }

    @Test
    @DisplayName("Обновление пользователя с авторизацией")
    public void updateUserWithAuthTest() {
        String token = userClient.login(user)
                .then().extract().path("accessToken");

        Response response = userClient.update(updatedUser, token);
        checkSuccessfulUpdate(response, updatedUser);
    }

    @Test
    @DisplayName("Обновление пользователя без авторизации")
    public void updateUserWithoutAuthTest() {
        Response response = userClient.update(updatedUser, "");
        checkUnauthorizedError(response);
    }

    @Step("Проверка успешного обновления пользователя")
    private void checkSuccessfulUpdate(Response response, User user) {
        response.then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("user.email", equalTo(user.getEmail()))
                .body("user.name", equalTo(user.getName()));
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
        String token = userClient.login(user)
                .then().extract().path("accessToken");
        if (token != null) {
            userClient.delete(token);
        }
    }
}
