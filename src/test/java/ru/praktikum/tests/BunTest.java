package ru.praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import ru.praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void setUp(){
        bun = new Bun("Gray bun", 2.5F);
    }

    @Test
    public void bunGetNameReturnName() {
        String expected = "Gray bun";
        String actual = bun.getName();
        assertEquals("Названия не совпадают!", expected, actual);
    }

    @Test
    public void bunGetPriceReturnPrice(){
        Float expected = 2.5F;
        Float actual = bun.getPrice();
        assertEquals("Цена не совпадает!", expected, actual);
    }

}
