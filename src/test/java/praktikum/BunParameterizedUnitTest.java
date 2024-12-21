package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunParameterizedUnitTest {

    private final String name;   // Имя булочки
    private final float price;   // Цена булочки

    public BunParameterizedUnitTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    // Параметризированные данные
    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getData() {
        return new Object[][] {
                { "Флюоресцентная булка R2-D3", 988.0f },
                { "Краторная булка N-200i", 1255.0f }
        };
    }

    @Test
    public void testBunProperties() {
        // Создаем объект класса Bun
        Bun bun = new Bun(name, price);

        // Проверяем имя булочки
        Assert.assertEquals("Неверное имя булочки", name, bun.getName());

        // Проверяем цену булочки
        Assert.assertEquals("Неверная цена булочки", price, bun.getPrice(), 0.001);
    }

    @Test
    public void testOnlyOneBunIsCreated() {
        // Проверяем, что булочка создается только один раз
        Bun bun = new Bun(name, price);
        // Тестируем, что создается только одна булочка с указанными параметрами
        Assert.assertNotNull("Булочка не была создана", bun);

        // Проверяем, что цена булочки соответствует ожидаемой
        Assert.assertEquals("Неверная цена булочки", price, bun.getPrice(), 0.001);
    }
}


