import org.junit.Test;
import praktikum.Bun;

import static junit.framework.TestCase.assertEquals;


public class BunTest {

    @Test
    public void getNameTest(){
        Bun bun = new Bun("Название Булки", 12.34f);
        assertEquals("Название Булки", bun.getName());
    }
    @Test
    public void getPriceTest(){
        Bun bun = new Bun("Название Булки", 12.34f);
        assertEquals(12.34f, bun.getPrice());
    }

}
