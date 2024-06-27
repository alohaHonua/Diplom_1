package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class BunTest {
    Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {RandomStringUtils.randomAlphabetic(20), 200F},
                {RandomStringUtils.randomAlphabetic(20), 3000F},
                {RandomStringUtils.randomAlphabetic(20), 0F},
                {RandomStringUtils.randomAlphabetic(20), 1F},
                {"", 200F},
                {"      ", 200F},
        };
    }

    @Before
    public void setup(){
        bun = new Bun(name, price);
    }
    @Test
public void getNameTest(){
        Assert.assertEquals(name, bun.getName());
    }
    @Test
    public void getPriceTest(){
        Assert.assertEquals(price, bun.getPrice(),0.01);
    }

}