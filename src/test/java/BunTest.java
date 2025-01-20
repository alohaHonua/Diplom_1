import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private String expectedName;
    private float expectedPrice;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"white", 100},          // Положительная цена
                {"black", 0},           // Нулевая цена
                {"rye", -50},           // Отрицательная цена
                {"multigrain", 99.99f},  // Положительная дробная цена
                {"", 100}, // Пустое имя
                {"^&^$%", 100}, // Спецсимволы
                {null, 100}, // Нулевое имя
                {"egrthretgertgrtegergergergergregerergerg", 100} //Длинное имя
        };
    }

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Before
    public void setUp() {
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void testBunGetName() {
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testBunGetPrice() {
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}
