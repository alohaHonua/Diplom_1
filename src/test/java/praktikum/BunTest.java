package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    private final String name = "Помпушка";
    private final float price = 1.45F;
    private Bun bun;

    // Перед каждым тестом создаем новую булочку, что бы если добавятся сеттеры мы работали с разными объектами
    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameReturnName() {
        String actualName = bun.getName();
        assertEquals(name, actualName);
    }

    @Test
    public void getPriceReturnPrice() {
        float actualPrice = bun.getPrice();
        assertEquals(price, actualPrice, 0);
    }
}