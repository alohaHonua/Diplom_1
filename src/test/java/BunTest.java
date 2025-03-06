import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.practikum.yandex.Bun;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;
    private boolean shouldThrowException;

    public BunTest(String name, float price, boolean shouldThrowException) {
        this.name = name;
        this.price = price;
        this.shouldThrowException = shouldThrowException;
    }

    @Parameterized.Parameters(name = "Тестовые данные: имя = {0}, цена = {1}, должно бросать исключение = {2}")
    public static Object[][] data() {
        return new Object[][]{

                //Buns
                {"", 5.0f, true}, // Пустое имя булочки
                {"БулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочкаБулочка", 5.0f, true}, // Слишком длинное имя
                {null, 5.0f, true}, // Null имя булочки
                {"Булочка@#$%", 5.0f, false}, // Имя со спецсимволами

                //Price
                {"Булочка", -1.0f, true}, // Отрицательная цена
                {"Булочка", 1.99f, false}, // Дробная цена
                {"Булочка", 0.0f, false}, // Нулевая цена
                {"Булочка", 5.0f, false}, // Корректная цена
                {"Булочка", Float.MAX_VALUE, false}, // Максимальное значение цены
                {"Булочка", 1.99f, false}, // Дробная цена
                {"Булочка", Float.MIN_VALUE, false} // Минимально допустимое положительное значение
        };
    }

    @Test
    public void testBunCreationThrowsException() {
        if (shouldThrowException) {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> new Bun(name, price));
            String expectedMessage = null;
            if (name == null || name.isEmpty() || name.length() > 50) {
                expectedMessage = "Invalid bun name";
            } else if (price < 0) {
                expectedMessage = "Price cannot be negative";
            }
            assertEquals("Сообщение об ошибке не соответствует ожидаемому", expectedMessage, exception.getMessage());
        }
    }

    @Test
    public void testBunCreationSuccessful() {
        if (!shouldThrowException) {
            Bun bun = new Bun(name, price);
            assertEquals("Имя булочки должно совпадать", name, bun.getName());
            assertEquals("Цена булочки должна совпадать", price, bun.getPrice(), 0.001);
        }
    }
}
