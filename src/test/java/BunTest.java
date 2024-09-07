import praktikum.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final Bun bun;
    public BunTest(String bunName, float bunPrice) {
        bun = new Bun(bunName, bunPrice);
    }
    @Parameterized.Parameters()
    public static Object[][] getBun() {
        return new Object[][]{
                {"Супер мега космеческая булочка", 100.10f},
                {"Super mega space bun", -100.10f},
                {"####", 0.123f},
                {"", 0.25f },
                {null, 0.0000001f}
        };
    }
    @Test
    public void checkBunName() {
        assertEquals(bun.name, bun.getName());
    }
    @Test
    public void checkBunPrice() {
        assertEquals("Ошибка: цены не сходятся", bun.price, bun.getPrice());
    }
}
