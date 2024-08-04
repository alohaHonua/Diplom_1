import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final Float price;
    private final Float expectedPrice;

    public BunTest(String name, Float price, Float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Белый Хлеб", 150.0f, 150.0f},
                {"Ржаной Хлеб", 200.0f, 200.0f},
                // Добавьте сюда другие тестовые данные
        });
    }

    @Test
    public void testConstructorAndPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
        assertEquals(expectedPrice, bun.getPrice(), 0.001f);
    }
}


