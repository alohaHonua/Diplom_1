import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setBunParameters() {
        return new Object[][]{
                {"red bun", 300},
                {"black bun", 100},
                {"white bun",200}
        };
    }

    @Test
    public void getNameReturnsNameTest(){
        Bun bun = new Bun(name,price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceReturnsPriceTest(){
        Bun bun = new Bun(name,price);
        Assert.assertEquals(price, bun.getPrice(),0);
    }
}
