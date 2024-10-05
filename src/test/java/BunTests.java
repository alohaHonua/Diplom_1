import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


public class BunTests {
    private  String bunTestName = "AnyText";
    private  float bunTestPrice = 1.0F;
    private  Bun bun;

    @Before
    public void setUp(){
        bun = new Bun(bunTestName, bunTestPrice);
    }

    @Test
    public void GetNameTest() {
        assertEquals(bunTestName, bun.getName());
    }

    @Test
    public void GetPriceTest() {
        assertEquals(bunTestPrice, bun.getPrice(), 0);
    }

}
