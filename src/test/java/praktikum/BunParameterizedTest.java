package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private String nameTest;
    private String bunName;
    private Float bunPrice;

    public BunParameterizedTest(String nameTest, String bunName, Float bunPrice) {
        this.nameTest = nameTest;
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name = "Тест {index} - {0}")
    public static Object[][]getColor() {
        return new Object[][]{
                {"Русские символы + min цена", "Русские символы", Float.MIN_VALUE},
                {"Русские символы + max цена", "Русские символы", Float.MAX_VALUE},
                {"Имя - латинские символы", "LatinLetters", 100.000000000F},
                {"Имя пусто", "", 100.000000000F},
                {"Имя null", null, 100.000000000F},
                {"Имя цифра", "123", 100.000000000F},
                {"Имя спецсимволы", "%:?", 100.000000000F},
                {"Цена ноль", "Булка", 0.000000000F},
                {"Цена отрицательная", "Булка", -100.000000000F},
        };
    }
    @Test
    public void testGetBunName() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunName,bun.getName());
    }
    @Test
    public void testGetBunPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunPrice, bun.getPrice(), 0);
    }
}
