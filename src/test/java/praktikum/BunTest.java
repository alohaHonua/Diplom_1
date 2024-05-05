package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    private Bun bun;

    @Test
    public void getNameTest() {
        bun = new Bun("black bun", 100);
        String executedName = bun.getName();
        assertEquals(executedName, "black bun");
    }

    @Test
    public void getPriceTest() {
        bun = new Bun("black bun", 100);
        Float executedPrice = bun.getPrice();
        assertEquals(executedPrice, 100, 0);
    }
}
