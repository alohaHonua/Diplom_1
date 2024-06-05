import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameBunTests() {
        Bun bun = new Bun("bunName", 1000);

        assertEquals("Некорректное наименование","bunName", bun.getName());
    }

    @Test
    public void getPriceBunTests() {
        Bun bun = new Bun("bunName", 1000.0f);

        assertEquals("Некорректная цена",1000.0f, bun.getPrice(), 0.001);
    }

}
