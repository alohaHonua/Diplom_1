import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    String name;
    float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Булочка", 50},
                {"!№;%^&*()", Float.MIN_VALUE},
                {" ", Float.MAX_VALUE},
               // {null, 0},
                // {"", 5500.99},
                {"Qwerty", -1255},
                {"Булка Сладкая сочная Мощная Красивая Соленая Булка Сладкая сочная Мощная Красивая Соленая", 1255},
                {"1234", 777.456f}
        };
    }

    @Test
    public void getNameBun() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceBun() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}