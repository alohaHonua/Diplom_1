import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;
import static praktikum.parameters.Parameters.BUN_NAME;
import static praktikum.parameters.Parameters.BUN_PRICE;

public class TestBun {
    Bun bun = new Bun(BUN_NAME, BUN_PRICE);

    @Test
    public void testGetName () {
        assertEquals(BUN_NAME, bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(BUN_PRICE, bun.getPrice(),0);
    }
}
