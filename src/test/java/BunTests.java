import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTests {

    @Test
    public void testBunConstructor() {
        Bun bun = new Bun("Sesame", 50.0f);
        assertEquals("Sesame", bun.getName());
        assertEquals(50.0f, bun.getPrice(), 0.001f); // Добавлена дельта
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun("Whole Grain", 45.0f);
        assertEquals("Whole Grain", bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("White", 40.0f);
        assertEquals(40.0f, bun.getPrice(), 0.001f); // Добавлена дельта
    }


}