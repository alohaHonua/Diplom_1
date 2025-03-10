import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParameterizedTests {
    private final String name;
    private final String expectedName;
    private final float price;
    private final float expectedPrice;

    public BunParameterizedTests(String name, String expectedName, float price, float expectedPrice){
        this.name = name;
        this.expectedName = expectedName;
        this.price = price;
        this.expectedPrice = price;
    }

    @Parameterized.Parameters
    public static Object[][] bunData() {
        return new Object[][] {
                {"Флюоресцентная булка R2-D2", "Флюоресцентная булка R2-D2", 988f, 988f},
                {"Краторная булка N-200i", "Краторная булка N-200i", 1255f, 1255f},
                {"Булка как булка", "Булка как булка", 500.250f, 500.250f},
        };
    }

    @Test
    public void bunNameTest(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(expectedName, bun.getName());
    }

    @Test
    public void bunPriceTest(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(expectedPrice, bun.price, 0);
    }

}
