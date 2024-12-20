package praktikum;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {


    @Test
    public void testBunWithValidNameAndPrice() {
        String name = "ValidName";
        float price = 10.50f;
        Bun bun = new Bun(name, price);
        System.out.println(bun.getName() + ",  " + bun.getPrice());
        assertEquals(name, bun.getName());
        assertEquals("Price should match the expected value", price, bun.getPrice(), 0.0f);
    }

    // --- Тесты для названия ---
    @Test
    public void testBunWithEmptyName() {
        String name = "";
        float price = 10.0f;
        Bun bun = new Bun(name, price);
        System.out.println(bun.getName() + ",  " + bun.getPrice());
        assertEquals("Name should be an empty string", name, bun.getName());
    }

    @Test
    public void testBunWithNullName() {
        String name = null;
        float price = 10.0f;
        Bun bun = new Bun(name, price);
        System.out.println(bun.getName() + ",  " + bun.getPrice());
        assertNull("Name should be null", bun.getName());
    }

    @Test
    public void testBunWithVeryLongName() {
        String name = "ABCname".repeat(1000); // Очень длинное имя
        float price = 10.0f;
        Bun bun = new Bun(name, price);
        System.out.println(bun.getName() + ",  " + bun.getPrice());
        assertEquals("Name should match the very long string", name, bun.getName());
    }

    @Test
    public void testBunWithSpecialCharactersInName() {
        String name = "!@#$%^&*()_+-=<>?/|";
        float price = 10.0f;
        Bun bun = new Bun(name, price);
        System.out.println(bun.getName() + ",  " + bun.getPrice());
        assertEquals("Name should match the string with special characters", name, bun.getName());
    }

    // --- Тесты для цены ---
    @Test
    public void testBunWithZeroPrice() {
        String name = "ValidName";
        float price = 0.0f;
        Bun bun = new Bun(name, price);
        System.out.println(bun.getName() + ",  " + bun.getPrice());
        assertEquals("Price should be zero", price, bun.getPrice(), 0.0f);
    }

    @Test
    public void testBunWithNegativePrice() {
        String name = "ValidName";
        float price = -10.0f;
        Bun bun = new Bun(name, price);
        System.out.println(bun.getName() + ",  " + bun.getPrice());
        assertEquals("Price should match the negative value", price, bun.getPrice(), 0.0f);
    }

    @Test
    public void testBunWithMinimalPositivePrice() {
        String name = "ValidName";
        float price = 0.01f;
        Bun bun = new Bun(name, price);
        System.out.println(bun.getName() + ",  " + bun.getPrice());
        assertEquals("Price should match the minimal positive value", price, bun.getPrice(), 0.0f);
    }

    @Test
    public void testBunWithMaximalPositivePrice() {
        String name = "ValidName";
        float price = Float.MAX_VALUE;
        Bun bun = new Bun(name, price);
        System.out.println(bun.getName() + ",  " + bun.getPrice());
        assertEquals("Price should match the maximal positive value", price, bun.getPrice(), 0.0f);
    }

    @Test
    public void testBunWithPriceHavingManyDecimalPlaces() {
        String name = "ValidName";
        float price = 123.456789f;
        Bun bun = new Bun(name, price);
        System.out.println(bun.getName() + ",  " + bun.getPrice());
        // Проверяем округление или сохранение точности
        assertEquals("Price should match the value with many decimal places", price, bun.getPrice(), 0.000001f);
    }
}
