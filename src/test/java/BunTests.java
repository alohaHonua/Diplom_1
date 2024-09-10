import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTests {
    private final String bunName;
    private final float bunPrice;


    public BunTests(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] bunData() {
        return new Object[][] {
                { "Флюоресцентная булка R2-D3", 988f},
                { "Краторная булка N-200i", 1255f},
        };
    }

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Неверная цена булочки" ,bunName, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Неверная цена булочки", bunPrice, bun.getPrice(), 0);
    }
}