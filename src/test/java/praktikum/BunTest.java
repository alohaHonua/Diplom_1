package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void getBunNameIsValidTest() {
        String expectedName = "Bun";
        Bun bun = new Bun(expectedName, 10.0f);
        String actualName = bun.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void getBunNameIsNullTest() {
        Bun bun = new Bun(null, 10.0f);
        String actualName = bun.getName();

        assertNull(actualName);
    }

    @Test
    public void getBunNameIsEmptyTest() {
        Bun bun = new Bun("", 10.0f);
        String actualName = bun.getName();

        assertEquals("", actualName);
    }

    @Test
    public void getBunPriceIsValidTest() {
        float expectedPrice = 100.0f;
        Bun bun = new Bun("Bun", expectedPrice);
        float actualPrice = bun.getPrice();

        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getBunPriceIsInvalidTest() {
        Bun bun = new Bun("Bun", -50.0f);
        float actualPrice = bun.getPrice();

        assertTrue(actualPrice < 0);
    }
}
