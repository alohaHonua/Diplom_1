package praktikum;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    private final String name = "Помпушка";
    private final float price = 1.45F;
    private Bun bun;


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