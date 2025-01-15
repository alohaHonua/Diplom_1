import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import io.qameta.allure.Step; // Подключение аннотации Step
import praktikum.Bun;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private String name;
    private float price;
    private boolean expectException;

    @Parameterized.Parameters(name = "{index}: Bun(name={0}, price={1})")
    public static Object[][] data() {
        return new Object[][] {
                {"", 100, false},                      // Пустое имя
                {null, 100, true},                     // null имя
                {"a".repeat(100), 100, false},        // Длинное имя
                {"@#$%^&*", 100, false},               // Специальные символы
                {"white bun", 200, false},             // Позитивное имя
                {"black bun", -100, false},            // Отрицательная цена
                {"white bun", 0, false},               // Нулевая цена
                {"red bun", 0.01f, false},             // Минимально положительная цена
                {"red bun", Float.MAX_VALUE, false}    // Максимально возможная цена
        };
    }

    public BunTest(String name, float price, boolean expectException) {
        this.name = name;
        this.price = price;
        this.expectException = expectException;
    }

    @Before
    public void setUp() {
    }

    @Test
    @Step("Тестирование создания булочки с параметрами: name={0}, price={1}")
    public void testBunCreation() {
        if (expectException) {
            assertThrows(NullPointerException.class, () -> {
                createBun(name, price);
            });
        } else {
            Bun bun = createBun(name, price);
            verifyBun(bun, name, price);
        }
    }

    @Step("Создание булочки с именем: {0} и ценой: {1}")
    private Bun createBun(String name, float price) {

        return new Bun(name, price);
    }

    @Step("Проверка булочки: имя {0}, цена {1}")
    private void verifyBun(Bun bun, String expectedName, float expectedPrice) {
        assertEquals(expectedName, bun.getName());
        assertEquals(expectedPrice, bun.getPrice(), 0.01);
    }
}



