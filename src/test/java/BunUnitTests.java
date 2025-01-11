import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)

public class  BunUnitTests {
    private final String name;
    private final float price;


    public BunUnitTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Краторная булка N-200i", 1255},
                {"Флюоресцентная булка R2-D3", 988},
                {"Флюоресцентная булка R2-D3", -988}, //проверка отрицательной цены
                {"Краторная булка N-200i"}, //проверка. когда не передана цена
                {"Флюоресцентная булка R2-D3", "300"} //проверка цены, переданной не числовым значением
        };
    }

    @Test
    public void checkBunParameterizedTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }

}

