package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {null, 0},
                {"", 1},
                {"!@#$%^&*()", -100},
                {",", -10000},
                {"-", -0.001F},
                {"12324", 56},
                {"поцпопоукгугппоииинееилиьоуишиоиоушкеишеоиывгшшщуериоиилкузщикуоилипgwgwgwhehehghrtbrtfgbbrtbt", 99999999},
                {"H", -999999999},
        };
    }

    @Before
    public void setUp(){
        bun = new Bun(name, price);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, bun.getPrice(),0);
    }
}