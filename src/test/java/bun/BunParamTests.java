package bun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParamTests {
    private String name;
    private float price;

    public BunParamTests(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        });
    }
    @Test
    public void getName() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }
    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0.01);
    }
}

