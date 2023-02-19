import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

/**
 * Тесты, покрывающие класс Bun
 *
 * @see Bun
 */
@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private final String actualBunName;
    private final float actualBunPrice;
    private final String expectedBunName;
    private final float expectedBunPrice;

    public BunParameterizedTest(String actualBunName, float actualBunPrice, String expectedBunName, float expectedBunPrice) {
        this.actualBunName = actualBunName;
        this.actualBunPrice = actualBunPrice;
        this.expectedBunName = expectedBunName;
        this.expectedBunPrice = expectedBunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][]{
                {"Bun", 1.95f, "Bun", 1.95f},
                {"", 5, "", 5},
                {"Bulo4ka", 99.99f, "Bulo4ka", 99.99f},
                {"!@#$%^&*()vfdb ", -120000000000000000000000000000f, "!@#$%^&*()vfdb ", -120000000000000000000000000000f},
                {null, 900000000000000000000000000000f, null, 900000000000000000000000000000f},
                {"     ", 0, "     ", 0}
        };
    }

    @Test
    public void shouldBeCreateBunWithNameAndPrice() {
        Bun bun = new Bun(actualBunName, actualBunPrice);
        assertEquals(bun.getName(), expectedBunName);
        assertEquals(bun.getPrice(), expectedBunPrice, 0.0);
    }
}
