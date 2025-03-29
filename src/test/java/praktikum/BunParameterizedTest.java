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
                {"black bun", 100.0f},
                {"white bun", 200.0f},
                {"red bun", 300.0f}
        });
    }

    @Test
    public void testBunGetName() {
        Bun bun = new Bun(expectedName, expectedPrice);
        String actualName = bun.getName();
        assertEquals("Название булочки не соответствует ожидаемому", expectedName, actualName);
    }

    @Test
    public void testBunGetPrice() {
        Bun bun = new Bun(expectedName, expectedPrice);
        float actualPrice = bun.getPrice();
        assertEquals("Цена булочки не соответствует ожидаемой", expectedPrice, actualPrice, 0.01f);
    }

}