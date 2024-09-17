import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTests {

    //test data
    private final String testName = "TestName";
    private final float testPrice = 666.66F;

    Bun bun = new Bun(testName, testPrice);

    @Test
    public  void getNameReturnsCorrectValue(){  Assert.assertEquals(testName, bun.getName());  }

    @Test
    public  void getPriceReturnsCorrectValue(){ Assert.assertEquals(bun.getPrice(), testPrice, 0.0);
    }


}
