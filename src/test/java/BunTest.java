import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private String bunName = "Star bun";
    private float bunPrice = 5;
    private Bun testBun;

    @Before
    public void SetUp(){
        testBun = new Bun(bunName, bunPrice);
    }


    @Test
    public void bunGetName(){
        Assert.assertEquals(bunName, testBun.getName());
    }

    @Test
    public void bunGetPrice(){
        Assert.assertEquals(bunPrice, testBun.getPrice(), 0.0);
    }
}
