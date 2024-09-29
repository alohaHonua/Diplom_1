import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {

    private String testName;
    private float testPrice;

    public BunParameterizedTest(String name, float price) {
        this.testName = name;
        this.testPrice = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Regular Bun", 2.50f},
                {"Sesame Bun", 3.00f},
                {"Whole Wheat Bun", 2.75f}
        });
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun(testName, testPrice);
        assertEquals(testName, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(testName, testPrice);
        assertEquals(testPrice, bun.getPrice(), 0.001);
    }
}