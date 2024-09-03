package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {

    private Bun bun;

    @Before
    public void initBun() {
        bun = new Bun("BlackBun", 10);
    }

    @Test
    public void getNameTest() {
        String expected = "BlackBun";
        var actual = bun.getName();
        Assert.assertEquals(
                "Получено неожидаемое название"
                ,expected,
                actual);
    }

    @Test
    public void getPriceTest() {
        float expected = 10;
        float actual = bun.getPrice();
        Assert.assertEquals(
                "Получена неожидаемая цена",
                expected,
                actual,
                0.01);
    }
}
