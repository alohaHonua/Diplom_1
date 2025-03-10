package praktikum.test;

import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
import static praktikum.constants.Constants.*;

public class BunTest {

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Булки", 1.5f);
        float price = bun.getPrice();

        assertEquals("Получаем цену булочке", 1.5f, price, DELTA);
    }

    @Test
    public void testGetName() {
        Bun bun = new Bun("Булки", 1.5F);
        String name = bun.getName();

        assertEquals("Получаем название модели","Булки", name);

    }
}
