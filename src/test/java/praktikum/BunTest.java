package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class BunTest {

    private List<Bun> buns;

    @Before
    public void setUp() {
        // Получаем все булочки из базы данных
        Database database = new Database();
        buns = database.availableBuns();
    }

    @Test
    public void testGetName() {
        // Проверяем название каждой булочки
        assertEquals("black bun", buns.get(0).getName());
        assertEquals("white bun", buns.get(1).getName());
        assertEquals("red bun", buns.get(2).getName());
    }

    @Test
    public void testGetPrice() {
        // Проверяем цену каждой булочки
        assertEquals(100.0, buns.get(0).getPrice(), 0.01);
        assertEquals(200.0, buns.get(1).getPrice(), 0.01);
        assertEquals(300.0, buns.get(2).getPrice(), 0.01);
    }
}
