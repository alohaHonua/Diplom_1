import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest {

    // проверка метода, возвращающего имя
    @Test
    public void bunNameTest() {
        Bun bun = new Bun("Classic", 10);
        assertEquals("Classic", bun.name);
    }

    // проверка метода, возвращающего стоимость
    @Test
    public void bunPriceTest() {
        Bun bun = new Bun("Zinger", 11);
        assertEquals(11, bun.getPrice(), 0.001);
    }
}
