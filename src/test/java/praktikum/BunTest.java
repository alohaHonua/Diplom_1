package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class BunTest extends ConstantData {

    Bun bun;

    @Before
    public void setUp(){
        bun = new Bun(ConstantData.BUN_NAME, ConstantData.BUN_PRICE);
    }


    @Test
    public void testGetName() {
        assertEquals(ConstantData.BUN_NAME, bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(ConstantData.BUN_PRICE, bun.getPrice(), 0.1);
    }
}
