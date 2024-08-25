package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void shouldReturnExpectedNameAndPriceWhenCreated() {
        String expectedName = "name";
        float expectedPrice = 3.14f;
        Bun bun = new Bun(expectedName, expectedPrice);

        String actualName = bun.getName();
        float actualPrice = bun.getPrice();

        assertEquals(expectedName, actualName);
        assertEquals(expectedPrice, actualPrice, 0);
    }
}