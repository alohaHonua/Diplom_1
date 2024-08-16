package praktikum;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    String nameBurger;
    float priceBurger;

    @Parameterized.Parameters
    public static Object[][] burgers() {
        return new Object[][]{
                {"Неонодог", 45.67F},
                {"Астронотерброд", Float.MIN_VALUE},
                {"Сендвонавт", Float.MAX_VALUE},
                {"", 76.34F},
        };
    }

    public BunParameterizedTest(String nameBurger, float priceBurger) {
        this.nameBurger = nameBurger;
        this.priceBurger = priceBurger;
    }

    @Test
    @DisplayName("Проверка получения названия булочки")
    public void getName() {
        Bun bun = new Bun(nameBurger, priceBurger);
        assertTrue(nameBurger.equals(bun.getName()));
    }

    @Test
    @DisplayName("Проверка получения цены булочки")
    public void getPrice() {
        Bun bun = new Bun(nameBurger, priceBurger);
        assertEquals(priceBurger, bun.getPrice(), 0.001F);
    }
}
