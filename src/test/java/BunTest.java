import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)//Аннотация говорящая что тест будет параметризированным
public class BunTest {
    private final String bunName;
    private final float bunPrice;
    private final String testName;


    public BunTest(String testName, String bunName, float bunPrice) {
        this.testName = testName;
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Object[][] getData() {
        return new Object[][] {
                { "Минимальная положительная цена", "Флюоресцентная булка R2-D3",0.01f},
                { "Минимальное название","B",988f},
                { "Спецсимволы в длинном названии", "Булочка космическая с Кунжутом-манжутом. \"ООО Парска\", Состав: Мука 'Лунейка' эмульгатор_B12(№2 с 16% метеоритной пыли <MPLQ> [ООО MilkWay!?] ); Длинное название булочки для проверки метода возвращающего ее значение в приложении stellar burgers", 500.01f},
                { "Отрицательная цена", "FLOURECENT",-1.25f},
                { "Пробелы перед и после названия + 0 цена", "  Space  ",0f},
                { "null в названии + большая цена", null, 4815162342.4815162342f},
                { "Пустое название", "",100f}
        };
    }

    @Test
    public void getNameBunNameShouldBeReturnedTest() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Ошибка. Должно было передаться название булочки" ,bunName, bun.getName());
    }

    @Test
    public void getPriceBunPriceShouldBeReturnedTest() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Ошибка. Должна была передаться цена булочки", bunPrice, bun.getPrice(), 0);
    }
}