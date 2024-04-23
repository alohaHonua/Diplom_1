import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Mock
    private Bun bun;

    private String name;
    private float price;

    @Test
    public void getNameTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, bun.getPrice(), 0.0);
    }

}
