import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    String name;
    float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
               {"Флюоресцентная булка R2-D3", 988.025f},
               {"Краторная булка N-200i", 1255}
        };
    }



    @Test
    public void getNameBun(){
     Bun bun = new Bun(name, price);
     Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceBun(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}

