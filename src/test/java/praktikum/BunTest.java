package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private final String testName;

    public BunTest(String name, float price, String testName) {
        this.name=name;
        this.price=price;
        this.testName=testName;
    }

    @Parameterized.Parameters (name = "{2}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {"Земная", 20.5f, "name: кириллица / price: один символ после запятой"},
                {"Earth", 0, "name: латиница / price: ноль"},
                {"Земная булка", -20.5f, "name: содержит пробел / price: отрицательное значение"},
                {"100500", 19.999999999f, "name: содержит цифры / price: девять символов после запятой"},
                {"$uper/g**d", 0.99f, "name: содержит спецсимволы / price: два символа после запятой"},
                {null, 5, "name: пустое поле / price: целое число"},
        };
    }

    @Test
    public void checkGetName() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Не совпадает название", name, bun.getName());
    }

    @Test
    public void checkGetPrice() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals("Не совпадает цена", price, bun.getPrice(),0);
    }
}