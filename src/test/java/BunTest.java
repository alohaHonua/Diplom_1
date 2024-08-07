import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    Bun bun;

    private final float expectedPrice;
    private final String expectedName;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedPrice = expectedPrice;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"Чёрная", 253},
                {"Белая", 147},
        };
    }


    @Test
    public void getNameTest() {

        bun = new Bun(expectedName, expectedPrice);
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getPriceTest() {

        bun = new Bun(expectedName, expectedPrice);
        assertEquals(expectedPrice, bun.getPrice(), 0.0f);
    }


}
