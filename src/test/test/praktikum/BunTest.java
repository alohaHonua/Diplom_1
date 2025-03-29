package praktikum;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getBunNameTest(){
        String actualName = "Булка";
        Bun bun = new Bun(actualName, 12);
        assertEquals("несоответствие названия булочки", actualName, bun.getName());
    }

    @Test
    public void getBunPriceTest(){
        float actualPrice = 50;
        Bun bun = new Bun("Булка", actualPrice);
        assertEquals("несоответствие цены булочки", actualPrice, bun.getPrice(),0.1);
    }
}
