package praktitum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestForBunWithParameterized {

    private String bunName;
    private float bunPrice;
    private Bun bun;

    public TestForBunWithParameterized(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.bun = new Bun(bunName, bunPrice);
    }

    @Parameterized.Parameters
    public static Object [][] bunParameters() {
        return new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    @Test
    public void testGetNameMethod(){
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void testGetPriceMethod(){
        assertEquals(bunPrice, bun.getPrice(), 0);
    }
}
