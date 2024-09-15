package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNamePriceReturnCorrectValue() {
        Bun bun = new Bun("Булочка", 5);
        String actName = bun.getName();
        float actPrice = bun.getPrice();
        assertEquals("Булочка", actName);
        assertEquals(5, actPrice, 0);
    }
}
