package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BunTest {
    private Bun bun;

    @Before
    public void createBun(){
        bun = new Bun ("black bun", 100);
    }

    @Test
    public void getNameTest(){
        String actualName = bun.getName();
        String expectedName = "black bun";
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceTest(){
        float actualPrice = bun.getPrice();
        float expectedPrice = 100;
        assertEquals(expectedPrice, actualPrice, 0);
    }
}
