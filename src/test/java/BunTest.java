import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void testConstructor(){
        Bun bun = new Bun("white bun", 200.0f);
        assertEquals("white bun", bun.getName());
        assertEquals(200.0f, bun.getPrice(), 0.001f);
        System.out.println("Тест прошел успешно: конструктор проверен");
    }

    @Test
    public void testNegativePriceShowsError() {
        try {
            Bun bun = new Bun("black bun", -100.0f);
            System.out.println("Ошибка: передана отрицательная цена");
        } catch (IllegalArgumentException e) {
            System.out.println("Исключение отработано: ввели отрицательную цену");
        }
    }
    @Test
    public void testGetName() {
        Bun bun = new Bun("white bun", 200.0f);
        assertEquals("white bun", bun.getName());
        System.out.println("Тест прошел успешно: возвращено заданное имя");
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("white bun", 200.0f);
        assertEquals(200.0f, bun.getPrice(), 0.001f);
        System.out.println("Тест прошел успешно: возвращена заданная цена");
    }
}
