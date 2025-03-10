import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParameterizedTests {
    private final String name;
    private final float price;

    public BunParameterizedTests(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] bunData() {
        return new Object[][] {
                {"Флюоресцентная булка R2-D2", 988f},
                {"Краторная булка N-200i", 1255f},
                {"Булка как булка", 500.250f},
        };
    }

    @Test
    public void bunNameTest(){
        Bun bun = createBun();
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void bunPriceTest(){
        Bun bun = createBun();
        Assert.assertEquals(price, bun.price, 0);
    }

    private Bun createBun(){
        return new Bun(name, price);
    }

}
