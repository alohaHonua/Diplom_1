package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    @Before
    public void setup() {
        bun = new Bun("Флюоресцентная булка R2-D3", 100);
    }
    @Test
    public void testGetBunName() {
    assertEquals("Флюоресцентная булка R2-D3",bun.getName());
    }
    @Test
    public void testGetBunPrice() {
    assertEquals(100, bun.getPrice(), 0);
    }
}
