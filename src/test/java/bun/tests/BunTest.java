package bun.tests;

import org.junit.Test;
import praktikum.Bun;

import static core.Constants.EXPECTED_BUN_NAME;
import static core.Constants.EXPECTED_BUN_PRICE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testGetBunName() {
        Bun bun = new Bun(EXPECTED_BUN_NAME, EXPECTED_BUN_PRICE);

        String actualBunName = bun.getName();

        assertEquals(String.format("Ожидается имя булочки %s", EXPECTED_BUN_NAME), EXPECTED_BUN_NAME, actualBunName);
    }

    @Test
    public void testGetBunPrice() {
        Bun bun = new Bun(EXPECTED_BUN_NAME, EXPECTED_BUN_PRICE);

        float actualBunPrice = bun.getPrice();

        assertThat(String.format("Ожидается цена булочки %.2f", EXPECTED_BUN_PRICE), actualBunPrice, is(EXPECTED_BUN_PRICE));
    }
}
