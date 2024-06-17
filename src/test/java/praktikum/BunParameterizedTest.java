package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    public static final int DELTA = 0;
    private final String bunName;
    private final Float bunPrice;

    public BunParameterizedTest(String bunName, Float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name = "Тест {index}")
    public static Object[][] getColor() {
        return new Object[][]{
                {"Русские символы", Float.MIN_VALUE},
                {"Русские символы", Float.MAX_VALUE},
                {"LatinLetters", 100.000000000F},
                {"", 100.000000000F},
                {null, 100.000000000F},
                {"123", 100.000000000F},
                {"%:?", 100.000000000F},
                {"Соусы", 0.000000000F},
                {"Соусы", -100.000000000F},
        };
    }
    @Test
    public void testGetBunName() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }
    @Test
    public void testGetBunPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunPrice, bun.getPrice(), DELTA);
    }
}
