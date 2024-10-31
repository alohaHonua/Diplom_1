import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun = new Bun("Булка", 20.5F);
    @Test
    public void bunsGetNameMethodTest(){
        Assert.assertEquals("Булка", bun.getName());
    }
    @Test
    public void bunsGetPriceMethodTest(){
        Assert.assertEquals(20.5F, bun.getPrice(), 0);
    }
}
