import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class BunParameterizedTest {

    public String bunName;
    public float bunPrice;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"R2-D3", 150.2F},
                {"N-200i", -100.0F},
                {null, 100.2F},
                {"", 0},
        };
    }

    public BunParameterizedTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Test
    public void getNameBunTest() {
        String expectedResult = bunName;

        Bun bun = new Bun(expectedResult, bunPrice);
        String actualResult = bun.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getPriceBunTest() {
        float expectedResult = bunPrice;

        Bun bun = new Bun(bunName, expectedResult);
        float actualResult = bun.getPrice();

        assertEquals(expectedResult, actualResult, 0);
    }
}