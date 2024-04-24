import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameBunTest() {
        String actualName = bun.getName();

        Assert.assertEquals("Имя булочки не соответствует ожидаемому значению", name, actualName);
    }

    @Test
    public void getPriceBunTest() {
        float actualPrice = bun.getPrice();

        Assert.assertEquals("Цена булочки не соответствует ожидаемому значению", price, actualPrice, 0);
    }
}
