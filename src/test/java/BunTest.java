import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private String testName;
    private float testPrice;

    @Before
    public void setTestData(){
        Random random = new Random();
        testName = "testName" + random.nextInt(1000000);
        testPrice = random.nextFloat();
    }

    @Test
    public void getNameTest(){
        Bun bun = new Bun(testName, testPrice);
        assertEquals(testName, bun.getName());
    }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun(testName, testPrice);
        assertEquals(testPrice, bun.getPrice(), 0.000001);
    }

}
