package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testBunCreation() {
        String expectedName = "Space Bun";
        float expectedPrice = 1.99f;
        Bun bun = new Bun(expectedName, expectedPrice);
        assertEquals(expectedName, bun.getName());
        assertEquals(expectedPrice, bun.getPrice(), 0.001);
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun("Space Whole Wheat Bun", 2.49f);
        String name = bun.getName();
        assertEquals("Space Whole Wheat Bun", name);
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Space Gluten Free Bun", 3.29f);
        float price = bun.getPrice();
        assertEquals(3.29f, price, 0.001);
    }
}