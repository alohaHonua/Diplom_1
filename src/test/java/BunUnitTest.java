import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunUnitTest {
    private final String expectedBunName;
    private final float expectedBunPrice;
    private final String description;

    public BunUnitTest(String description, String expectedBunName, float expectedBunPrice) {
        this.description = description;
        this.expectedBunName = expectedBunName;
        this.expectedBunPrice = expectedBunPrice;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Object[][] parameters() {
        return new Object[][] {
                { "Минимально допустимая цена", "Флюоресцентная булка R2-D3", 0.01f },
                { "Краткое название", "B", 988f },
                { "Проверка специальных символов",
                        "Булочка космическая с Кунжутом-манжутом. \"ООО Парска\", Состав: Мука 'Лунейка' эмульгатор_B12(№2 с 16% метеоритной пыли <MPLQ> [ООО MilkWay!?] ); Длинное название булочки для проверки метода возвращающего ее значение в приложении stellar burgers",
                        500.01f },
                { "Некорректная (отрицательная) цена", "FLOURECENT", -1.25f },
                { "Пробелы вокруг названия + нулевая цена", "  Space  ", 0f },
                { "Проверка null в названии с высокой ценой", null, 162342.162342f },
                { "Проверка пустого названия", "", 100f }
        };
    }

    @Test
    public void shouldReturnBunName() {
        Bun bun = new Bun(expectedBunName, expectedBunPrice);
        assertEquals("Не совпадает название булочки", expectedBunName, bun.getName());
    }

    @Test
    public void shouldReturnBunPrice() {
        Bun bun = new Bun(expectedBunName, expectedBunPrice);
        assertEquals("Не совпадает цена булочки", expectedBunPrice, bun.getPrice(), 0);
    }
}
