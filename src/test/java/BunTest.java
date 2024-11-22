import org.junit.Test;
import praktikum.*;
import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void testGetBunName(){
        Bun bun = new Bun("test bun", 132);
        assertEquals("test bun", bun.getName());
    }

    @Test
    public void testGetBunPrice(){
        Bun bun = new Bun("test bun", 144);
        assertEquals(144, bun.getPrice(), 0.01);
    }

}
