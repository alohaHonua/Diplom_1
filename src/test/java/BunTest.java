import jdk.jfr.Description;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private static String name = TestDataCreator.getName();
    private static float price = TestDataCreator.getPrice();
    Bun bun = new Bun(name,price);

    @Test
    @Description("Проверка присвоения имени")
    public void getNameCheck() {
        assertEquals(name, bun.getName());
    }

    @Test
    @Description("Проверка присвоения цены")
    public void getPriceCheck() {
        assertEquals(price, bun.getPrice(), 0);
    }
}
