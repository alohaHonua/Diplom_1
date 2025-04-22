import org.junit.Assert;
import org.junit.Before;
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
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> bunData() {
        return Arrays.asList(new Object[][]{
                {"Ржаная", 5.2f},
                {"Пшеничная", 10.0f},
        });
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Имя должно быть ожидаемым", name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals("Цена должна быть ожидаемой", price, bun.getPrice(), 0.0f);
    }
}