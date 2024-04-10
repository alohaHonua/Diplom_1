import org.junit.Before;
import org.junit.Test;
import praktikum.*;
import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    private String name = "Sairis Bun";
    private float price = 5.00f;

    @Before
    public void newBun() {

        bun = new Bun(name, price);
    }

    @Test
    public void getNameTest() {
        assertEquals(name,bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(price,bun.getPrice(),0);
    }
}
