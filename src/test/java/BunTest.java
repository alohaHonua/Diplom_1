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

    @Parameterized.Parameters(name = "{index}: Bun(name={0}, price={1})")
    public static Object[][] data() {
        return new Object[][] {
                {"", 100},                      // Пустое имя
                {"a".repeat(100), 100},        // Длинное имя
                {"@#$%^&*", 100},               // Специальные символы
                {"white bun", 200},             // Позитивное имя
                {"white bun", 0},               // Нулевая цена
                {"red bun", 0.01f},             // Минимально положительная цена
                {"red bun", Float.MAX_VALUE}    // Максимально возможная цена
        };
    }

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Test
    public void testBunCreationName() {
            Bun bun = createBun(name, price);
           verifyBunName(bun, name);
            }

    @Test
    public void testBunCreationPrice() {
        Bun bun = createBun(name, price);
        verifyBunPrice(bun, price);
    }

    private Bun createBun(String name, float price){
        return new Bun(name, price);
    }

    @Step ("Проверка булочки: имя {0}")
    private void verifyBunName(Bun bun, String expectedName) {
        assertEquals(expectedName, bun.getName());
    }

    @Step ("Проверка булочки: цена {0}")
    private void verifyBunPrice(Bun bun, float expectedPrice) {
        assertEquals(expectedPrice, bun.getPrice(), 0.01);
    }
}



