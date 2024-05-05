import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


public class BunTest {

    final String name = "black bun";
    final float price = 100;

    @Test
    public void getNameTest() {
        Bun bun = new Bun("black bun", 100);
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("black bun", 100);
        assertEquals(price, bun.getPrice(), 0.0);
    }

}
