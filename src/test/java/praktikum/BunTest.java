package test;


import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getBunName(){
        String actualName = "Булка";
        Bun bun = new Bun(actualName, 12);
        assertEquals(actualName, bun.getName());
    }

    @Test
    public void getBunPrice(){
        float actualPrice = 50;
        Bun bun = new Bun("Булка", actualPrice);
        assertEquals(actualPrice, bun.getPrice(),0.1);
    }
}
