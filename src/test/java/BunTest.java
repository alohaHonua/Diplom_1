import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private String expectedName;
    private float expectedPrice;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"light saber bun", 14.8F},
                {"blaster colour bun", 15.6f},
                {"premium bun", 66.6f},

        };
    }


    @Test
    public void getNameTest() {
        Bun testBun = new Bun(expectedName, expectedPrice);

        String actual = testBun.getName();
        String expected = expectedName;

        assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        Bun testBun = new Bun(expectedName, expectedPrice);

        float actual = testBun.getPrice();
        float expected = expectedPrice;

        assertEquals(expected, actual, 0);
    }
}
