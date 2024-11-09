package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private static final int DELTA = 0;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] testData() {
        return new Object[][]{
                {"Булочка с кунжутом", 449.99f},
                {"Краторная булка N-200i", 1255},
                //Проверка для цены, равной нулю
                {"Булочка с кунжутом", 0},
                //Проверка для цены, которая равна максимально возможному значению
                {"Булочка с кунжутом", Float.MAX_VALUE},
                //Проверка для цены, которая равна минимально возможному значению
                {"Булочка с кунжутом", Float.MIN_VALUE},
                //Проверка для цены, которая содержит нечисловое значение
                {"Флюоресцентная булка R2-D3", Float.NaN},
        };
    }

    @Test
    public void getNameBunTest() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceBunTest() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), DELTA);
    }
}
