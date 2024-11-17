package tests;

import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testBunConstructorSetsNameAndPrice() {
        // Используем данные из Database
        String expectedName = "black bun";
        float expectedPrice = 100.0f;

        Bun bun = new Bun(expectedName, expectedPrice);

        assertEquals("Name should be set correctly", expectedName, bun.getName());
        assertEquals("Price should be set correctly", expectedPrice, bun.getPrice(), 0.0f);
    }

    @Test
    public void testGetNameReturnsCorrectName() {
        // Используем данные из Database
        String expectedName = "white bun";
        Bun bun = new Bun(expectedName, 200.0f);

        assertEquals("getName should return the correct name", expectedName, bun.getName());
    }

    @Test
    public void testGetPriceReturnsCorrectPrice() {
        // Используем данные из Database
        float expectedPrice = 300.0f;
        Bun bun = new Bun("red bun", expectedPrice);

        assertEquals("getPrice should return the correct price", expectedPrice, bun.getPrice(), 0.0f);
    }
}
