package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    private final String name = "Name";
    private final float price = 123.34f;

    @Before
    public void setUp() {
        bun  = new Bun(name, price);
    }
    @Test
    public void getName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPrice(){
        assertEquals(price, bun.getPrice(), 0.001);
    }


}
