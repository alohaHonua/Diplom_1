package praktikum.bun;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.TestConstants;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String bunName;
    private final float bunPrice;
    private final float expectedPrice;

    private Bun bun;

    public BunTest(String bunName, float bunPrice, float expectedPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TestConstants.BLACK_BUN_NAME, TestConstants.BLACK_BUN_PRICE, TestConstants.BLACK_BUN_PRICE},
                {TestConstants.WHITE_BUN_NAME, TestConstants.WHITE_BUN_PRICE, TestConstants.WHITE_BUN_PRICE}
        });
    }

    @Before
    public void setUp() {
        bun = new Bun(bunName, bunPrice);
    }

    // Проверка имени булочки
    @Test
    public void testGetBunName() {
        assertEquals(bunName, bun.getName());
    }

    // Проверка цены булочки
    @Test
    public void testGetBunPrice() {
        assertEquals(expectedPrice, bun.getPrice(), TestConstants.DELTA);
    }
}
