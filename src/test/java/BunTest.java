import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String expectedName;
    private final float expectedPrice;

public BunTest (String expectedName, Float expectedPrice) {
    this.expectedName = expectedName;
    this.expectedPrice = expectedPrice;
}
    @Parameterized.Parameters
    public static Object[][] testBunData() {
        return new Object[][] {
                {"Флюоресцентная булка", 988f},
                {"white bun", 200f},
                {"Свежая булочка", 0f},
                {"black bun", -100f},
                {" ", 178.55f}
        };
    }
    @Test
    public void getNameBunTest() {
        Bun bun = new Bun(expectedName,expectedPrice);
        assertEquals("Название булочки не соответствует ожидаемому", expectedName, bun.getName());
    }

    @Test
    public void getPriceBunTest() {
        Bun bun = new Bun(expectedName,expectedPrice);
        assertEquals("Цена булочки не соответствует ожидаемому", expectedPrice, bun.getPrice(), 0);
    }
}

