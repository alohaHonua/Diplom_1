package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {

    private final String name;
    private final float price;

    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Sesame", 25.0f},
                {"Rye", 30.5f},
                {"Wheat", 45.0f}
        });
    }

    @Test
    public void testParameterizedConstructor() {
        Bun paramBun = new Bun(name, price);
        assertEquals(name, paramBun.getName());
        assertEquals(price, paramBun.getPrice(), 0.001f);
    }
}