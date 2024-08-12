import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

import praktikum.Bun;

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
                {"white bun", 100.0f},
                {"black bun", 200.0f},
                {"red bun", 300.0f},
                {null, 0},
                {"Русский", 1.05f},
                {"!@#$%^&*()_+{}|:?><", Float.MIN_VALUE},
                {"    ", Float.MAX_VALUE}
        });
    }

    @Test
    public void bunGetNameReturnsCorrectName() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void bunGetPriceReturnsCorrectPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0.0f);
    }
}
