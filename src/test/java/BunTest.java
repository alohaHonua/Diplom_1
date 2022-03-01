
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun = new Bun("булочка", 22.4F);

    @Test
    public void nameReturnedTest(){
        assertEquals("Неверное имя","булочка",bun.getName());
    }
    @Test
    public void priceReturnedTest(){
        assertEquals("Неверная цена",22.4F, bun.getPrice(), 0.0001);
    }
}
