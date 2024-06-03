import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final static double DELTA = 0.0;
    private final String bunName;
    private final float bunPrice;
    private Bun testBun;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[] getProperty(){
        return new Object[][]{
                {"Just bun", 10},
                {"No_bug_Bun", 0},
        };
    }

    @Before
    public void setUp(){
        testBun = new Bun(bunName, bunPrice);
    }


    @Test
    public void bunGetName(){
        Assert.assertEquals(bunName, testBun.getName());
    }

    @Test
    public void bunGetPrice(){
        Assert.assertEquals(bunPrice, testBun.getPrice(), DELTA);
    }
}
