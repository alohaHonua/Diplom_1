import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;
public class BunTest {
    @Test
    public void bunGetPriceTest() {
        Bun bun = new Bun( "С кунжутом", 8.50f);
        assertEquals(bun.getPrice(), 8.50f, 0);
    }
    @Test
    public void bunGetNameTest() {
        Bun bun = new Bun( "С кунжутом", 8.50f);
        assertEquals(bun.getName(), "С кунжутом");
    }
}
