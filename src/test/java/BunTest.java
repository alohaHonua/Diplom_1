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
    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][] {
                { "Лунная булка", 10.5f},
                {"Космическая булочка", 12.8f},
                {"Иноплонетная булка", 5}
        };
    }
    @Test
    public void bunCreationTest() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Название бургера должно быть " + bunName, bunName, bun.getName());
        assertEquals("Цена бургера должна быть " + bunPrice, bunPrice, bun.getPrice(), 0.001f);
    }
}
