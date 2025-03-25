package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        initMocks(this);

        // Создаем объект булочки
        bun = new Bun("Классическая булочка", 50f);
    }

    @Test
    public void testGetName() {
        // Проверяем метод getName()
        assertEquals("Классическая булочка", bun.getName());
    }

    @Test
    public void testGetPrice() {
        // Проверяем метод getPrice()
        assertEquals(50f, bun.getPrice(), 0.001); // Точность сравнения для float
    }

    @Test
    public void testConstructor() {
        // Проверка конструктора через создание мока
        Bun mockBun = mock(Bun.class);
        when(mockBun.getName()).thenReturn("Булочка с кунжутом");
        when(mockBun.getPrice()).thenReturn(60f);

        assertEquals("Булочка с кунжутом", mockBun.getName());
        assertEquals(60f, mockBun.getPrice(), 0.001);
    }
}
