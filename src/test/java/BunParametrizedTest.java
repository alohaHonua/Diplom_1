import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParametrizedTest {
    private String name;
    private float price;
    public BunParametrizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Bun {index} -> Name: {0}, Price: {1} ")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {"", 300},
                {"veryveryveryverylooooooooonggggggggggstriiiiiiing", 200},
                {null, 100},
                {"$%#^@&$$(%^^)special@symbols", 200},
                {"white bun", -100},
                {"white bun", 0.01f},
                {"red 1234", 300},
                {"Cheap bun", Float.MIN_VALUE},
                {"Expensive bun", Float.MAX_VALUE},

        };
    }
    @Test
    public void getName() {
        Bun bun = new Bun(name, price);
        assertEquals("Неверное название булочки",name, bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Неверная цена булочки", price, bun.getPrice(), 0.0f);
    }
}
