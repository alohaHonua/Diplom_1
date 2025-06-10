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

public class UserTests {
    private User user;
    private UserClient userClient;

    @Before
    public void setUp() {
        user = User.getRandomUser();
        userClient = new UserClient();
    }

    @Test
    @DisplayName("Создание уникального пользователя")
    public void createUniqueUserTest() {
        Response response = userClient.create(user);
        checkSuccessfulUserCreation(response, user);
    }

    @Test
    @DisplayName("Создание дубликата пользователя")
    public void createDuplicateUserTest() {
        userClient.create(user);
        Response response = userClient.create(user);
        checkDuplicateUserError(response);
    }

    @Test
    @DisplayName("Создание пользователя без обязательного поля")
    public void createUserWithoutRequiredFieldTest() {
        user.setEmail(null);
        Response response = userClient.create(user);
        checkMissingFieldError(response);
    }

    @Test
    @DisplayName("Вход в систему с действительными учетными данными")
    public void loginWithValidCredentialsTest() {
        userClient.create(user);
        Response response = userClient.login(user);
        checkSuccessfulLogin(response, user);
    }

    @Test
    @DisplayName("Вход в систему с неверными учетными данными")
    public void loginWithInvalidCredentialsTest() {
        Response response = userClient.login(user);
        checkInvalidCredentialsError(response);
    }

    @Step("Проверка успешного создания пользователя")
    private void checkSuccessfulUserCreation(Response response, User user) {
        response.then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("user.email", equalTo(user.getEmail()))
                .body("user.name", equalTo(user.getName()))
                .body("accessToken", not(emptyOrNullString()))
                .body("refreshToken", not(emptyOrNullString()));
    }

    @Step("Проверка ошибки при попытке создания дубликата пользователя")
    private void checkDuplicateUserError(Response response) {
        response.then()
                .statusCode(403)
                .body("success", equalTo(false))
                .body("message", equalTo("User already exists"));
    }

    @Step("Проверка ошибки отсутствующего поля")
    private void checkMissingFieldError(Response response) {
        response.then()
                .statusCode(403)
                .body("success", equalTo(false))
                .body("message", equalTo("Email, password and name are required fields"));
    }

    @Step("Проверка успешного входа в систему")
    private void checkSuccessfulLogin(Response response, User user) {
        response.then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("user.email", equalTo(user.getEmail()))
                .body("user.name", equalTo(user.getName()))
                .body("accessToken", containsString("Bearer"))
                .body("refreshToken", not(emptyOrNullString()));
    }

    @Step("Ошибка проверки недопустимых учетных данных")
    private void checkInvalidCredentialsError(Response response) {
        response.then()
                .statusCode(401)
                .body("success", equalTo(false))
                .body("message", equalTo("email or password are incorrect"));
    }

    @After
    public void tearDown() {
        if (user.getEmail() != null && user.getPassword() != null) {
            String token = userClient.login(user)
                    .then().extract().path("accessToken");
            if (token != null) {
                userClient.delete(token);
            }
        }
    }
}
