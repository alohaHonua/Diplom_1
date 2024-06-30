import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{index}: Test with name={0}, price={1}")
    public static Object[][] data() {
        return new Object[][]{
                {"fluorescent", 500F},
                {"crater", 1000F},
                {"custom", 1515.15F}
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
        System.out.println("Проверка метода getName с именем = " + name);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0.1F);
        System.out.println("Проверка метода getPrice со стоимостью = " + price);
    }
}
