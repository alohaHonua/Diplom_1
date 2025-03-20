import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParamTest {

    String name;
    float price;
    Bun bun;

    public BunParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Before
    public void initBun() {
        bun = new Bun(name, price);
    }

    // Проверим работу класса с разными входными данными
    @Parameterized.Parameters
    public static Object[][] setSex() {
        return new Object[][]{
                {"Гамбургер", 4.0f},
                {"Чизбургер", 3.0f},
                {"23423выа", 2.2f},
                {"Чикенролл", 4.5f},
                {"", 1.0f},
                {null, 1.1f}
        };
    }

    // проверка метода, возвращающего имя
    @Test
    public void bunNameTest() {
        assertEquals("Бургер должен иметь название", name, bun.name);
    }

    // проверка метода, возвращающего стоимость
    @Test
    public void bunPriceTest() {
        assertEquals("Бургер должен иметь цену", price, bun.getPrice(), 0.001);
    }
}
