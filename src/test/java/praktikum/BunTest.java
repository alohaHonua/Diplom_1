package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    // Тесты на метод getName
    @Test
    public void testGetNameReturnsCorrectValue() {

        String expectedName = "Краторная булка N-200i";
        float price = 1255f;
        Bun bun = new Bun(expectedName, price);
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetNameWhenNameIsNull() {

        Bun bun = new Bun(null, 1255f);
        String actualName = bun.getName();
        assertNull(actualName);
    }

    @Test
    public void testGetNameWithEmptyString() {

        Bun bun = new Bun("", 1255f);
        String actualName = bun.getName();
        assertEquals("", actualName);
    }

    // Тесты на метод getPrice
    @Test
    public void testGetPriceWithCorrectPrice() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988f);
        assertEquals(988f, bun.getPrice(), 0.001f);
    }

    @Test
    public void testGetPriceWithNegativePrice() {
        Bun bun = new Bun("Краторная булка N-200i", -1255f);
        assertEquals(-1255f, bun.getPrice(), 0.001f);
    }

    @Test
    public void testGetPriceWithZeroPrice() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 0);
        assertEquals(0, bun.getPrice(), 0.001f);
    }

}
