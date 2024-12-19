package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    static float delta = 0.0f;

    @Test
    public void getNameTest() {
        Bun bun = new Bun("test", 2.5f);
        Assert.assertEquals("test", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("test", 0.23f);
        Assert.assertEquals(0.23f, bun.getPrice(), delta);
    }
}
