package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameReturnSameNameTest() {
       String name = "Супербулка";
       Bun bun = new Bun(name, 0);
       assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceReturnPriceTest() {
        float price = 10.1f;
        Bun bun = new Bun("Супербулка", price);
        assertEquals(price, bun.getPrice(), 0.001f);
    }
}
