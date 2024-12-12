import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void getNameBunTest(){
        Bun bun = new Bun("White bun", 35.4345F);
        String expectedResult = "White bun";
        Assert.assertEquals(expectedResult, bun.getName());
    }

    @Test
    public void getPriceBunTest(){
        Bun bun = new Bun("White bun", 35.4345F);
        float expectedResult = 35.4345F;
        Assert.assertEquals(expectedResult, bun.getPrice(), 0.001F);
    }
}
