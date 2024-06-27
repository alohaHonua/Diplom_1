import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final float bunPrice;
    private final String bunName;
    Bun bun;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {"black bun", 100f},
                {"white bun", 200f},
                {"red bun", 300f},
                {"nub kcalb", 0.0f},
                {"BULICHKA", Float.MAX_VALUE},
                {"42", Float.MIN_VALUE},
                {"", 0f},
                {null, 0.1f},
                {"!!!@@@###$$$%%%^^^&&&", 12345}
        };
    }

    @Before
    public void setup() {
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void getBunNameTest() {
        System.out.println("Checking if \"" + bunName + "\" = \"" + bun.getName()+"\"");
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        System.out.println("Checking if " + bunPrice + " = " + bun.getPrice());
        assertEquals(bunPrice, bun.getPrice(), 0);
    }

}
