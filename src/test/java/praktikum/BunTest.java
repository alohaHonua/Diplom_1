package praktikum;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private String name;
    private float price;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"12345", 10.0f},
                {null, 9.0f},
                {"", 8.0f},
                {"White bun", 7.5f},
                {"!@#", 6.0f},
                {" ", 5.0f},
                {"Spicy, hot bun", 4.0f},
                {"Sweet bun", Float.MIN_VALUE},
                {"Salty bun", Float.MAX_VALUE}
        };
    }

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Test
    public void bunGetName() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void bunGetPrice() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }

}
