package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunPriceTest {

    private final float expectedPrice;

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                { 0f },
                { 1f },
                { -1f },
                { 0.5f },
                { -0.5f },
                { Float.MAX_VALUE },
                { Float.MIN_VALUE },
        };
    }

    public BunPriceTest(float expectedPrice){
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void checkPriceTest(){
        String name = "Test name";
        Bun bun = new Bun(name, expectedPrice);
        assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}
