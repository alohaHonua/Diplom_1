import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;

    @Test
    public void getNameTest() {
         bun = new Bun("black bun", 100);
         assertEquals("black bun", bun.getName());
    }

    @Test
    public void getPriceTest() {
        bun = new Bun("black bun", 100);
        assertEquals(100, bun.getPrice(), 0.01);
    }

}
