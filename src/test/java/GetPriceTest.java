import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)

public class GetPriceTest {

    final private float price;
    String name;

    public GetPriceTest(float price) {
        this.price = price;
    }

    @Parameterized.Parameters (name = "Тестовые данные Price: {0} ")
    public static Object[][] bunPrice() {
        return new Object[][]{
                {0},
                {0.5f},
                {100},
                {200.123456789012345678901234567890f},
                {299.9f},
                {300},
                {999999999},
        };
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();
        Assert.assertEquals("Цена не соответствует переданному значению", price, actual, 0);
    }
}