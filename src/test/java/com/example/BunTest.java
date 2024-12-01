package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTest {

    @Test
    public void testGetName() {
        String expectedName = "just bun";
        Bun bun = new Bun(expectedName, 100.0f);

        String actualName = bun.getName();

        assertEquals(expectedName, actualName, "Метод getName вернул некорректное имя.");
    }

    @Test
    public void testGetPrice() {
        float expectedPrice = 200.0f;
        Bun bun = new Bun("bun", expectedPrice);

        float actualPrice = bun.getPrice();

        assertEquals(expectedPrice, actualPrice, "Метод getPrice вернул некорректно цену.");
    }
}