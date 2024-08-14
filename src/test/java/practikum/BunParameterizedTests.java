package practikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTests {

    private Bun bun;

    private String name;
    private float price;

    public BunParameterizedTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Проверка методов класса Bun. Методы возвращают: getName = {0},  getPrice = {1}.")
    public static Object[][] buns() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    @Before
    public void initTest() {
        bun = new Bun(name, price);
    }

    @Test
    public void checkGetName() {
        String expectedName = name;
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void checkGetPrice() {
        float expectedPrice = price;
        assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}