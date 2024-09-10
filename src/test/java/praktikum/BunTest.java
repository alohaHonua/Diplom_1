package praktikum;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun = new Bun("TestName", 42.0f);

    @Test
    public void getName() {
        String result = bun.getName();
        assertEquals("TestName", result);
    }

    @Test
    public void getPrice() {
        float result = bun.getPrice();
        assertEquals(42.0f, result, 0.05f);
    }
}