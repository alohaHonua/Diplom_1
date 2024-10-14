package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final Bun bun;

    public BunTest(String bunName, float bunPrice) {
        bun = new Bun(bunName, bunPrice);
    }

    @Parameterized.Parameters(name = "bunName: {0}; bunPrice: {1}")
    public static Object[][] getBun() {
        return new Object[][]{
                {"Флюоресцентная", 988.0f},
                {"Kratornaya", 1255},
                {null, 0},
                {"", 0.5f }
        };
    }

    @Test
    public void getExpectedNameEqualsActual() {
        // {0 - expected} {1 - actual}
        assertEquals(bun.name, bun.getName());
    }

    @Test
    public void getExpectedPriceEqualsActual() {
        // {1 - expected} {2 - actual}
        assertEquals("getPrice Error", bun.price, bun.getPrice(), 0);
    }
}