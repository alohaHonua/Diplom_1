

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final Float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;

    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}

        };
    }

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();

        assertEquals(name, actual);

    }
   @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();

        assertEquals(price, actual,0);

    }
}
