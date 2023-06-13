import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BunTests {

    @Mock Bun bun;

    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void getName_shouldReturnActualName() {
        Bun bun = new Bun("Red bun", 100f);
        Assert.assertEquals("Red bun", bun.getName());
    }

    @Test
    public void getPrice_shouldReturnDoubleBunPrice() {
        Bun realBun = new Bun("Real Bun", 100f);
        Burger burger = new Burger();
        burger.setBuns(realBun);

        float actualPrice = burger.getPrice();
        Assert.assertEquals(200f, actualPrice, 0.001f);
    }

}