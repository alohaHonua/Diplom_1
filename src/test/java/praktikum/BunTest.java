package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters(name = "Тестовые данные: name = {0}, price = {1}")
    public static Object[][] getBunsData() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }


    @Test
    public void getBunNameTest() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        Assert.assertEquals(price, bun.getPrice(), 0.00001f);
    }
}
