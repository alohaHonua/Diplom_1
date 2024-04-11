import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;
public class TestBun {
    Bun bun = new Bun("white bun" , 102.3f);


    @Test
    public void checkNameTest(){
        String expectedResult = "white bun";
        String actualResult = bun.getName();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkPriceTest(){
        float expectedResult = 102.3f;
        float actualResult = bun.getPrice();
        Assert.assertEquals(expectedResult, actualResult, 0);
    }


}
