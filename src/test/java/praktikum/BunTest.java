package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)  // Подключаем параметризацию
public class BunTest {

    private final String name;
    private final float price;
    private final Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
        this.bun = new Bun(name, price);
    }

    // Параметры для тестов
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Краторная булка", 300},
                {"Флюоресцентная булка", 200},
                {"", 0},  // Граничный случай: пустое название
                {"Большая булка", Float.MAX_VALUE}  // Граничный случай: максимальная цена
        });
    }

    @Test
    public void testGetName() {
        assertEquals("Название булки должно совпадать", name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals("Цена булки должна совпадать", price, bun.getPrice(), 0.001f);
    }
}