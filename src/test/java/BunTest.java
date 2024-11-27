import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    @Spy
    Bun bun = new Bun("black bun", 100);

    @Test
    public void getName() {
        bun.getName();
        Mockito.verify(bun, Mockito.times(1)).getName();
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void getPrice() {
        bun.getPrice();

        Mockito.verify(bun, Mockito.times(1)).getPrice();
        assertEquals(100, bun.getPrice(), 0);

    }

}
