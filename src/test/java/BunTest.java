import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    private final Bun bun;

    public BunTest(String name, float price) {
        this.name = name;

        this.price = price;

        this.bun = new Bun(this.name, this.price);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Ржаная булочка", 200},
                {"Булочка с кунжутом", 100}
        });
    }

    @Test
    public void bunNameTest() {
        Assert.assertEquals("Название булочки не соответствует заданному при инициации", this.name, bun.getName());
    }

    @Test
    public void bunPriceTest() {
        Assert.assertEquals("Цена булочки не соответствует заданной при инициации", this.price, bun.getPrice(), 0);
    }
}
