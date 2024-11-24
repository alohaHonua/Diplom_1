import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 998f},
                {"Краторная булка N-200i", 1255f},
                {null, 998f},
                {"Булка из черного хлеба", -0.01f},
                {"Булка из белого хлеба", 4815162342.4815162342f}
        };
    }

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Ошибка. Должно было передаться название булочки" ,bunName, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Ошибка. Должна была передаться цена булочки", bunPrice, bun.getPrice(), 0);
    }
}




