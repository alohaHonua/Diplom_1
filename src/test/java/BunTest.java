import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;
    private final String BUN_NAME = "Space bun";
    private final float BUN_PRICE = 0.9f;

    @Before
    public void setUp() {
       bun = new Bun(BUN_NAME, BUN_PRICE);
    }

@Test
    public void getNameTest() {
    assertEquals("Наименование булочки", BUN_NAME, bun.getName());
}

@Test
    public void getPriceTest() {
    assertEquals("Цена булочки", BUN_PRICE, bun.getPrice(), Constants.DELTA);
}

@Test
    public void bunConstructorTest() {
    assertEquals(BUN_NAME, bun.getName());
    assertEquals(BUN_PRICE, bun.getPrice(), Constants.DELTA);
}

}
