package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private String expectedName;
    private float expectedPrice;

    public BunParameterizedTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Тестовые данные: название = {0}, цена = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"black Bun", 100.0f},
                {"white Bun", 200.0f},
                {"red Bun", 300.0f}
        });
    }

    @Test
    public void testBun() {

        Bun bun = new Bun(expectedName, expectedPrice);

        String actualName = bun.getName();
        float actualPrice = bun.getPrice();

        assertEquals("Название булочки не соответствует ожидаемому", expectedName, actualName);
        assertEquals("Цена булочки не соответствует ожидаемой", expectedPrice, actualPrice, 0.01f);
    }
}