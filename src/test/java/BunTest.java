import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Сахарная", 3.50f);
    }

    @Test
    public void constructorBunClassTest() {
        String expectedNameOfBun = "Маковая";
        float expectedPriceOfBun = 5.34f;
        bun = new Bun(expectedNameOfBun, expectedPriceOfBun);

        String actualName = bun.getName();
        float actualPrice = bun.getPrice();

        Assert.assertEquals("Название булочки создается некорректно", expectedNameOfBun, actualName);
        Assert.assertEquals("Стоимость булочки создается некорректно", expectedPriceOfBun, actualPrice, 0.0f);
    }

    @Test
    public void getBunNameTest() {
        String expected = "Сахарная";
        String actual = bun.getName();
        Assert.assertEquals("Название булочки не совпадает с ожидаемым", expected, actual);
    }

    @Test
    public void getPriceTest() {
        float expected = 3.50f;
        float actual = bun.getPrice();
        Assert.assertEquals("Стоимость булочки не совпадает с ожидаемой", expected, actual, 0.0f);
    }
}
