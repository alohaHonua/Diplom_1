import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    public String bunName;
    public float bunPrice;
    public BunTest(String BunName, float BunPrice) {

        this.bunName = BunName;
        this.bunPrice = BunPrice;
    }
    @Parameterized.Parameters
    public static Object[][] bun() {
        return new Object[][]{

                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {"yellow bun", 400},
        };
    }
    //Проверка Иемни булочки
    @Test
    public void checkBunName(){
        Bun bunTest = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bunTest.getName());

    }
    //Проверка цены булочки
    @Test
    public void checkBunPrice(){
        Bun bunTest = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunPrice, bunTest.getPrice(), 0);

    }

}
