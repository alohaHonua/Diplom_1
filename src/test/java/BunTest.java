import org.junit.*;
import org.mockito.Mock;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    @Mock
    private static String name;
    @Mock
    private static float price;
    private static Bun bun;

    @BeforeClass
    public static void init() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameMockNameAssertValid() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceMockPriceAssertValid() {
        assertEquals(price, bun.getPrice(), 0.0001);
    }
}
