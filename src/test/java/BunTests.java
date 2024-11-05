import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BunTests {

    String name = "bun";

    @Test
    public void testBunCreation() {
        float price = 0.0005F;

        Bun bun = new Bun(name, price);

        assertNotNull(bun);
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(), 0.0001f);
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun(name, 0.2F);

        String actualName = bun.getName();

        assertEquals(name, actualName);
    }

    @Test
    public void testGetPrice() {
        float price = 0.1F;
        Bun bun = new Bun("white bun", price);

        float actualPrice = bun.getPrice();

        assertEquals(0.01, actualPrice, 0.1);
    }
}

